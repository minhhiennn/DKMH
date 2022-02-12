/*
 * Created on 2022-02-12 ( 18:57:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package code.webdkmh.dao.entities;

import java.io.Serializable;


/**
 * Composite primary key for entity "SubPass" ( stored in table "Sub_Pass" )
 *
 * @author Telosys
 *
 */
public class SubPassId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     idSemester ;
    
    private String     idCourse ;
    
    private String     idStudent ;
    
    /**
     * Constructor
     */
    public SubPassId() {
        super();
    }

    /**
     * Constructor with values
     * @param idSemester 
     * @param idCourse 
     * @param idStudent 
     */
    public SubPassId( String idSemester, String idCourse, String idStudent ) {
        super();
        this.idSemester = idSemester ;
        this.idCourse = idCourse ;
        this.idStudent = idStudent ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setIdSemester( String value ) {
        this.idSemester = value;
    }
    public String getIdSemester() {
        return this.idSemester;
    }

    public void setIdCourse( String value ) {
        this.idCourse = value;
    }
    public String getIdCourse() {
        return this.idCourse;
    }

    public void setIdStudent( String value ) {
        this.idStudent = value;
    }
    public String getIdStudent() {
        return this.idStudent;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		SubPassId other = (SubPassId) obj; 
		//--- Attribute idSemester
		if ( idSemester == null ) { 
			if ( other.idSemester != null ) 
				return false ; 
		} else if ( ! idSemester.equals(other.idSemester) ) 
			return false ; 
		//--- Attribute idCourse
		if ( idCourse == null ) { 
			if ( other.idCourse != null ) 
				return false ; 
		} else if ( ! idCourse.equals(other.idCourse) ) 
			return false ; 
		//--- Attribute idStudent
		if ( idStudent == null ) { 
			if ( other.idStudent != null ) 
				return false ; 
		} else if ( ! idStudent.equals(other.idStudent) ) 
			return false ; 
		return true; 
	} 

    //--- hashCode METHOD
	@Override
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute idSemester
		result = prime * result + ((idSemester == null) ? 0 : idSemester.hashCode() ) ; 
		//--- Attribute idCourse
		result = prime * result + ((idCourse == null) ? 0 : idCourse.hashCode() ) ; 
		//--- Attribute idStudent
		result = prime * result + ((idStudent == null) ? 0 : idStudent.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(idSemester);
        sb.append("|");
        sb.append(idCourse);
        sb.append("|");
        sb.append(idStudent);
        return sb.toString(); 
    } 

}
