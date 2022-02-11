package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}