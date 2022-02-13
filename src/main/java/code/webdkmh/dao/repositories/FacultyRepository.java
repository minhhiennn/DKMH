package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
}