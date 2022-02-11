package code.webdkmh.dao.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubPassId implements Serializable {
    private static final long serialVersionUID = -7042461614678517604L;
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String idStudent;
    @Column(name = "ID_Course", nullable = false, length = 50)
    private String idCourse;
    @Column(name = "ID_Semester", nullable = false, length = 50)
    private String idSemester;

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, idSemester, idStudent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubPassId entity = (SubPassId) o;
        return Objects.equals(this.idCourse, entity.idCourse) &&
                Objects.equals(this.idSemester, entity.idSemester) &&
                Objects.equals(this.idStudent, entity.idStudent);
    }
}