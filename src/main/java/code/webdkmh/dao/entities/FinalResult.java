/*
 * Created on 2022-02-12 ( 18:57:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package code.webdkmh.dao.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "FinalResult"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="Final_Result", schema="dbo", catalog="Course_Registration" )
public class FinalResult implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ID_Student", nullable=false, length=50)
    private String     idStudent ;

    //--- ENTITY DATA FIELDS 
    @Column(name="grade_Av")
    private Double     gradeAv ;

    @Column(name="grade_Av_4")
    private Double     gradeAv4 ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToOne
    @JoinColumn(name="ID_Student", referencedColumnName="ID_Student", insertable=false, updatable=false)
    private Student    student ; 


    /**
     * Constructor
     */
    public FinalResult() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setIdStudent( String idStudent ) {
        this.idStudent = idStudent ;
    }
    public String getIdStudent() {
        return this.idStudent;
    }

    public void setGradeAv( Double gradeAv ) {
        this.gradeAv = gradeAv ;
    }
    public Double getGradeAv() {
        return this.gradeAv;
    }

    public void setGradeAv4( Double gradeAv4 ) {
        this.gradeAv4 = gradeAv4 ;
    }
    public Double getGradeAv4() {
        return this.gradeAv4;
    }

    //--- GETTERS FOR LINKS
    public Student getStudent() {
        return this.student;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(idStudent);
        sb.append("|");
        sb.append(gradeAv);
        sb.append("|");
        sb.append(gradeAv4);
        return sb.toString(); 
    } 

}
