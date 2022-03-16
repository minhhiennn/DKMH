package code.webdkmh.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import code.webdkmh.dao.entities.StudentSchedule;

public interface StudentScheduleRepository extends JpaRepository<StudentSchedule, String> {

    @Query("SELECT p FROM StudentSchedule p WHERE  p.idSemester = ?1 and p.idSchedule = ?2 and p.idStudent = ?3 ")
    StudentSchedule findByID_SemesterAndID_ScheduleAndID_Student(String idSemester, String idSchedule,
            String idStudent);
}