package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.StudentScheduleR;
import code.webdkmh.dao.entity.StudentScheduleRId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScheduleRRepository extends JpaRepository<StudentScheduleR, StudentScheduleRId> {
}