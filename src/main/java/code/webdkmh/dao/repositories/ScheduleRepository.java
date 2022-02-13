package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}