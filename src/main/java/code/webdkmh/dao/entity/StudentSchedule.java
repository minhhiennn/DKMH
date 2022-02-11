package code.webdkmh.dao.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Schedule")
public class StudentSchedule {
    @EmbeddedId
    private StudentScheduleId id;

    public StudentScheduleId getId() {
        return id;
    }

    public void setId(StudentScheduleId id) {
        this.id = id;
    }
}