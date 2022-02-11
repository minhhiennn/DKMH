package code.webdkmh.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Course_Offering")
public class CourseOffering {
    @Id
    @Column(name = "ID_Course_Offering", nullable = false, length = 50)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Course", nullable = false)
    private Course idCourse;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Clazz_code", nullable = false)
    private Clazz clazzCode;

    @Column(name = "Max_Size", nullable = false)
    private Integer maxSize;

    @Column(name = "Current_Size", nullable = false)
    private Integer currentSize;

    public Integer getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Integer currentSize) {
        this.currentSize = currentSize;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Clazz getClazzCode() {
        return clazzCode;
    }

    public void setClazzCode(Clazz clazzCode) {
        this.clazzCode = clazzCode;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}