package code.webdkmh.dao.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfessorScheduleId implements Serializable {
    private static final long serialVersionUID = -5663245721423459368L;
    @Column(name = "ID_Professor", nullable = false, length = 50)
    private String idProfessor;
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

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemester, idProfessor, idSchedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfessorScheduleId entity = (ProfessorScheduleId) o;
        return Objects.equals(this.idSemester, entity.idSemester) &&
                Objects.equals(this.idProfessor, entity.idProfessor) &&
                Objects.equals(this.idSchedule, entity.idSchedule);
    }
}