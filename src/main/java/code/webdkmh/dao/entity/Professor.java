package code.webdkmh.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Professor")
public class Professor {
    @Id
    @Column(name = "ID_Professor", nullable = false, length = 50)
    private String id;

    @Column(name = "Professor_Name", nullable = false, length = 50)
    private String professorName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Faculty", nullable = false)
    private Faculty idFaculty;

    @Column(name = "Create_date", nullable = false)
    private LocalDate createDate;

    @Column(name = "Degree", length = 50)
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}