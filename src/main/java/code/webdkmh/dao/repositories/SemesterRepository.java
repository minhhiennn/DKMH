package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, String> {
}