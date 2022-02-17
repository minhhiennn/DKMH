package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.BillingSystem;
import code.webdkmh.dao.entities.ProfessorSchedule;
import code.webdkmh.dao.entities.ProfessorScheduleId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorScheduleRepository extends JpaRepository<ProfessorSchedule, ProfessorScheduleId> {
}