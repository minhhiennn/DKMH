package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.ProfessorSchedule;
import code.webdkmh.dao.entity.ProfessorScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorScheduleRepository extends JpaRepository<ProfessorSchedule, ProfessorScheduleId> {
}