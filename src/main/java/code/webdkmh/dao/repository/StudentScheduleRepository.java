package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.StudentSchedule;
import code.webdkmh.dao.entity.StudentScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScheduleRepository extends JpaRepository<StudentSchedule, StudentScheduleId> {
}