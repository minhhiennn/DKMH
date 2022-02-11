package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.SemesterResult;
import code.webdkmh.dao.entity.SemesterResultId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterResultRepository extends JpaRepository<SemesterResult, SemesterResultId> {
}