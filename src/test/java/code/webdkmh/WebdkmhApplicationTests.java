package code.webdkmh;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import code.webdkmh.dao.entities.Course;
import code.webdkmh.dao.entities.CourseOffering;
import code.webdkmh.dao.entities.FinalResult;
import code.webdkmh.dao.entities.SemesterResult;
import code.webdkmh.dao.entities.SemesterResultId;
import code.webdkmh.dao.entities.Student;
import code.webdkmh.dao.entities.SubPass;
import code.webdkmh.dao.repositories.CourseOfferingRepository;
import code.webdkmh.dao.repositories.FinalResultRepository;
import code.webdkmh.dao.repositories.SemesterResultRepository;
import code.webdkmh.dao.repositories.StudentScheduleRepository;
import code.webdkmh.dao.repositories.SubPassRepository;
import code.webdkmh.utli.readFileExcel.PointReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdkmhApplicationTests {

	@Autowired
	CourseOfferingRepository courseOfferingRepository;
	@Autowired
	SubPassRepository subPassRepository;
	@Autowired
	SemesterResultRepository semesterResultRepository;
	@Autowired
	FinalResultRepository finalResultRepository;
	@Autowired
	StudentScheduleRepository studentScheduleRepository;
	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	public void myTest() throws IOException {
		PointReader pointReader = new PointReader();
		File file = new File("./data/excel/8.xlsx");
		List<SubPass> subPasses = new ArrayList<>();
		List<SemesterResult> semesterResults = new ArrayList<>();
		List<FinalResult> finalResults = new ArrayList<>();
		String errorMess = "";
		String fileNameNoExt = FilenameUtils.removeExtension(file.getName());
		String idSemester = "2018_1";
		CourseOffering courseOffering = courseOfferingRepository.findById(fileNameNoExt).get();
		Course course = courseOffering.getCourse();

		Map<Integer, Double> mapOfStudents = pointReader.StudentCount(file);
		for (Map.Entry<Integer, Double> entry : mapOfStudents.entrySet()) {
			if (entry.getKey() < 0) {
				if (entry.getValue().equals(0.0)) {
					errorMess += "Sai o dong so " + Math.abs(entry.getKey()) + " : " + " sai dinh dang" + "\n";
				} else {
					errorMess += "Sai o dong so " + Math.abs(entry.getKey()) + " : " + " diem so khong phu hop" + "\n";
				}
				continue;
			}
			String idStudent = Integer.toString(entry.getKey());

			if (studentScheduleRepository.findByID_SemesterAndID_ScheduleAndID_Student(idSemester,
					courseOffering.getListOfSchedule().get(0).getIdSchedule(), idStudent) == null) {
				errorMess += "Sinh vien ma so " + idStudent + " khong co dang ky mon nay" + "\n";
				continue;
			}

			Double currentGrade = entry.getValue();
			String rate = "";
			if (currentGrade > 8) {
				rate = "A";
			} else if (currentGrade >= 6 && currentGrade <= 8) {
				rate = "B";
			} else if (currentGrade >= 5 && currentGrade <= 6) {
				rate = "C";
			} else if (currentGrade >= 5 && currentGrade <= 6) {
				rate = "D";
			} else {
				rate = "F";
			}
			SubPass subPass = new SubPass(idSemester, course.getIdCourse(), idStudent, currentGrade,
					currentGrade * (0.4), rate);
			int creditGetSemester = course.getCourseCertificate();
			Double gradeAvSemester = currentGrade * creditGetSemester;
			int creditGetFinal = course.getCourseCertificate();
			Double gradeAvFinal = currentGrade * creditGetFinal;
			List<SubPass> subPassesOfThisStudent = subPassRepository.findByID_Student(idStudent);
			for (SubPass subPassIter : subPassesOfThisStudent) {
				if (!subPassIter.getIdCourse().equals(course.getIdCourse())
						&& subPassIter.getIdSemester().equals(idSemester)) {
					int creditOfThisSub = subPassIter.getCourse().getCourseCertificate();
					Double scoreOfThisSub = subPassIter.getScore();
					creditGetFinal += creditOfThisSub;
					gradeAvFinal += scoreOfThisSub * creditOfThisSub;
					if (subPassIter.getIdSemester().equals(idSemester)) {
						creditGetSemester += creditOfThisSub;
						gradeAvSemester += scoreOfThisSub * creditOfThisSub;
					}
				}
			}
			gradeAvSemester = gradeAvSemester / creditGetSemester;
			gradeAvFinal = gradeAvFinal / creditGetFinal;
			SemesterResult semesterResult = new SemesterResult(idSemester, idStudent, gradeAvSemester,
					gradeAvSemester * (0.4), creditGetSemester);
			FinalResult finalResult = new FinalResult(idStudent, gradeAvFinal, gradeAvFinal * (0.4));
			subPasses.add(subPass);
			semesterResults.add(semesterResult);
			finalResults.add(finalResult);

		}

		if (errorMess.equals("")) {
			subPassRepository.saveAll(subPasses);
			semesterResultRepository.saveAll(semesterResults);
			finalResultRepository.saveAll(finalResults);
			errorMess = "Succesfull";
		}
		System.out.println(errorMess + " okok");
		// return errorMess;
	}

	@Test
	@Transactional
	public void name2() {
		SemesterResultId id = new SemesterResultId("2018_1", "18130001");
		System.out.println(entityManager.find(SemesterResult.class, id) + " ok ok");
	}

}