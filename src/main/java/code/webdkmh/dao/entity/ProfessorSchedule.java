package code.webdkmh.dao.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Professor_Schedule")
public class ProfessorSchedule {
    @EmbeddedId
    private ProfessorScheduleId id;

    public ProfessorScheduleId getId() {
        return id;
    }

    public void setId(ProfessorScheduleId id) {
        this.id = id;
    }
}