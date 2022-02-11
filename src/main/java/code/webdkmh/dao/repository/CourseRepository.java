package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}