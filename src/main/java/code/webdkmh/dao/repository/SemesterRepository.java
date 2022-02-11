package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, String> {
}