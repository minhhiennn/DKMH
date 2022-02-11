package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}