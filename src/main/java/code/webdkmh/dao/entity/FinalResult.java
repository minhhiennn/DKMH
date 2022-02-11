package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Final_Result")
public class FinalResult {
    @Id
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String id;

    @Column(name = "grade_Av")
    private Double gradeAv;

    @Column(name = "grade_Av_4")
    private Double gradeAv4;

    public Double getGradeAv4() {
        return gradeAv4;
    }

    public void setGradeAv4(Double gradeAv4) {
        this.gradeAv4 = gradeAv4;
    }

    public Double getGradeAv() {
        return gradeAv;
    }

    public void setGradeAv(Double gradeAv) {
        this.gradeAv = gradeAv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}