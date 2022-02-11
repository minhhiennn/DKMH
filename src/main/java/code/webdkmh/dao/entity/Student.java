package code.webdkmh.dao.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String id;

    @Column(name = "Student_Name", nullable = false, length = 50)
    private String studentName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Faculty", nullable = false)
    private Faculty idFaculty;

    @Column(name = "Create_date", nullable = false)
    private Instant createDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Clazz_code", nullable = false)
    private Clazz clazzCode;

    @Column(name = "Cert_number_required", nullable = false)
    private Integer certNumberRequired;

    @Column(name = "Cert_number_accumulated", nullable = false)
    private Integer certNumberAccumulated;

    public Integer getCertNumberAccumulated() {
        return certNumberAccumulated;
    }

    public void setCertNumberAccumulated(Integer certNumberAccumulated) {
        this.certNumberAccumulated = certNumberAccumulated;
    }

    public Integer getCertNumberRequired() {
        return certNumberRequired;
    }

    public void setCertNumberRequired(Integer certNumberRequired) {
        this.certNumberRequired = certNumberRequired;
    }

    public Clazz getClazzCode() {
        return clazzCode;
    }

    public void setClazzCode(Clazz clazzCode) {
        this.clazzCode = clazzCode;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}