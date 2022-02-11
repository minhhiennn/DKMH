package code.webdkmh.dao.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SemesterResultId implements Serializable {
    private static final long serialVersionUID = -6806753865874650470L;
    @Column(name = "ID_Semester", nullable = false, length = 50)
    private String idSemester;
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String idStudent;

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemester, idStudent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SemesterResultId entity = (SemesterResultId) o;
        return Objects.equals(this.idSemester, entity.idSemester) &&
                Objects.equals(this.idStudent, entity.idStudent);
    }
}