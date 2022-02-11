package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}