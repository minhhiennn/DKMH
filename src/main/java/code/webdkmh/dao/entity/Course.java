package code.webdkmh.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name = "ID_Course", nullable = false, length = 50)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Faculty", nullable = false)
    private Faculty idFaculty;

    @Column(name = "Name_Course", nullable = false, length = 50)
    private String nameCourse;

    @Column(name = "Course_certificate", nullable = false)
    private Integer courseCertificate;

    @Column(name = "years", nullable = false)
    private Integer years;

    @Column(name = "number_S")
    private Integer numberS;

    public Integer getNumberS() {
        return numberS;
    }

    public void setNumberS(Integer numberS) {
        this.numberS = numberS;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getCourseCertificate() {
        return courseCertificate;
    }

    public void setCourseCertificate(Integer courseCertificate) {
        this.courseCertificate = courseCertificate;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}