package code.webdkmh.dao.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Schedule_R")
public class StudentScheduleR {
    @EmbeddedId
    private StudentScheduleRId id;

    public StudentScheduleRId getId() {
        return id;
    }

    public void setId(StudentScheduleRId id) {
        this.id = id;
    }
}