package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "front_Sub")
public class FrontSub {
    @Id
    @Column(name = "ID_Course", nullable = false, length = 50)
    private String id;

    @Column(name = "ID_Course_B", length = 50)
    private String idCourseB;

    public String getIdCourseB() {
        return idCourseB;
    }

    public void setIdCourseB(String idCourseB) {
        this.idCourseB = idCourseB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}