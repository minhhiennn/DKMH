package code.webdkmh.dao.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentScheduleRId implements Serializable {
    private static final long serialVersionUID = -1042554108101255575L;
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String idStudent;
    @Column(name = "ID_Semester", nullable = false, length = 50)
    private String idSemester;
    @Column(name = "ID_Schedule", nullable = false, length = 50)
    private String idSchedule;

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemester, idSchedule, idStudent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentScheduleRId entity = (StudentScheduleRId) o;
        return Objects.equals(this.idSemester, entity.idSemester) &&
                Objects.equals(this.idSchedule, entity.idSchedule) &&
                Objects.equals(this.idStudent, entity.idStudent);
    }
}