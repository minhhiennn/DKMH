package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "semester_Result")
public class SemesterResult {
    @EmbeddedId
    private SemesterResultId id;

    @Column(name = "grade_Av")
    private Double gradeAv;

    @Column(name = "grade_Av_4")
    private Double gradeAv4;

    @Column(name = "credit_Get")
    private Integer creditGet;

    public Integer getCreditGet() {
        return creditGet;
    }

    public void setCreditGet(Integer creditGet) {
        this.creditGet = creditGet;
    }

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

    public SemesterResultId getId() {
        return id;
    }

    public void setId(SemesterResultId id) {
        this.id = id;
    }
}