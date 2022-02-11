package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Time_For_Course_Register")
public class TimeForCourseRegister {
    @Id
    @Column(name = "ID_Semester", nullable = false, length = 50)
    private String id;

    @Column(name = "start_Date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_Date", nullable = false)
    private LocalDate endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}