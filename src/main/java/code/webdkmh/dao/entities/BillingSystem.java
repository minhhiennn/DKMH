/*
 * Created on 2022-02-12 ( 18:57:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package code.webdkmh.dao.entities;


import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "BillingSystem"
 *
 * @author Telosys
 */
@Entity
@Table(name = "Billing_System", schema = "dbo", catalog = "Course_Registration")
@IdClass(BillingSystemId.class)
public class BillingSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name = "ID_Semester", nullable = false, length = 50)
    private String idSemester;

    @Id
    @Column(name = "ID_Student", nullable = false, length = 50)
    private String idStudent;

    //--- ENTITY DATA FIELDS 
    @Column(name = "Paymoney")
    private Double paymoney;

    @Column(name = "creadit")
    private Short creadit;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name = "ID_Student", referencedColumnName = "ID_Student", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ID_Semester", referencedColumnName = "ID_Semester", insertable = false, updatable = false)
    private Semester semester;


    /**
     * Constructor
     */
    public BillingSystem() {
        super();
    }

    //--- GETTERS & SETTERS FOR FIELDS
    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public String getIdSemester() {
        return this.idSemester;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdStudent() {
        return this.idStudent;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }

    public Double getPaymoney() {
        return this.paymoney;
    }

    public void setCreadit(Short creadit) {
        this.creadit = creadit;
    }

    public Short getCreadit() {
        return this.creadit;
    }

    //--- GETTERS FOR LINKS
    public Student getStudent() {
        return this.student;
    }

    public Semester getSemester() {
        return this.semester;
    }

    //--- toString specific method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idSemester);
        sb.append("|");
        sb.append(idStudent);
        sb.append("|");
        sb.append(paymoney);
        sb.append("|");
        sb.append(creadit);
        return sb.toString();
    }

}
