package code.webdkmh.dao.managers;

import code.webdkmh.dao.entities.StudentSchedule;
import code.webdkmh.dao.repositories.StudentScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Component
public class StudentScheduleManager {

	private StudentScheduleRepository studentScheduleRepository;

	@Autowired
	public StudentScheduleManager(StudentScheduleRepository studentScheduleRepository) {
		this.studentScheduleRepository = studentScheduleRepository;
	}

}
