package code.webdkmh.dao.managers;

import code.webdkmh.dao.entities.CourseOffering;
import code.webdkmh.dao.repositories.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Component
public class CourseOfferingManager {

	private CourseOfferingRepository courseOfferingRepository;

	@Autowired
	public CourseOfferingManager(CourseOfferingRepository courseOfferingRepository) {
		this.courseOfferingRepository = courseOfferingRepository;
	}

}
