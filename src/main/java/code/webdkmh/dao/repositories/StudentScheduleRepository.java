package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.StudentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScheduleRepository extends JpaRepository<StudentSchedule, String> {
}