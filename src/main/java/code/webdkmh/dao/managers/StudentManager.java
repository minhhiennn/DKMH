package code.webdkmh.dao.managers;

import code.webdkmh.dao.entities.Student;
import code.webdkmh.dao.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Component
public class StudentManager {

	private StudentRepository studentRepository;

	@Autowired
	public StudentManager(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

}
