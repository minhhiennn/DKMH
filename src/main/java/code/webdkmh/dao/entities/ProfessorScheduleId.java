/*
 * Created on 2022-02-12 ( 18:57:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package code.webdkmh.dao.entities;

import java.io.Serializable;

/**
 * Composite primary key for entity "ProfessorSchedule" ( stored in table
 * "Professor_Schedule" )
 *
 * @author Telosys
 *
 */
public class ProfessorScheduleId implements Serializable {

    private static final long serialVersionUID = 1L;

    // --- ENTITY KEY ATTRIBUTES
    private String idSemester;

    private String idSchedule;

    private String idProfessor;

    /**
     * Constructor
     */
    public ProfessorScheduleId() {
        super();
    }

    /**
     * Constructor with values
     * 
     * @param idSemester
     * @param idSchedule
     * @param idProfessor
     */
    public ProfessorScheduleId(String idSemester, String idSchedule, String idProfessor) {
        super();
        this.idSemester = idSemester;
        this.idSchedule = idSchedule;
        this.idProfessor = idProfessor;
    }

    // --- GETTERS & SETTERS FOR KEY FIELDS
    public void setIdSemester(String value) {
        this.idSemester = value;
    }

    public String getIdSemester() {
        return this.idSemester;
    }

    public void setIdSchedule(String value) {
        this.idSchedule = value;
    }

    public String getIdSchedule() {
        return this.idSchedule;
    }

    public void setIdProfessor(String value) {
        this.idProfessor = value;
    }

    public String getIdProfessor() {
        return this.idProfessor;
    }

    // --- equals METHOD
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        ProfessorScheduleId other = (ProfessorScheduleId) obj;
        // --- Attribute idSemester
        if (idSemester == null) {
            if (other.idSemester != null)
                return false;
        } else if (!idSemester.equals(other.idSemester))
            return false;
        // --- Attribute idSchedule
        if (idSchedule == null) {
            if (other.idSchedule != null)
                return false;
        } else if (!idSchedule.equals(other.idSchedule))
            return false;
        // --- Attribute idProfessor
        if (idProfessor == null) {
            if (other.idProfessor != null)
                return false;
        } else if (!idProfessor.equals(other.idProfessor))
            return false;
        return true;
    }

    // --- hashCode METHOD
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        // --- Attribute idSemester
        result = prime * result + ((idSemester == null) ? 0 : idSemester.hashCode());
        // --- Attribute idSchedule
        result = prime * result + ((idSchedule == null) ? 0 : idSchedule.hashCode());
        // --- Attribute idProfessor
        result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());

        return result;
    }

    // --- toString METHOD
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idSemester);
        sb.append("|");
        sb.append(idSchedule);
        sb.append("|");
        sb.append(idProfessor);
        return sb.toString();
    }

}
