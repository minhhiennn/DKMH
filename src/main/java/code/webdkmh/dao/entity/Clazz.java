package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clazz")
public class Clazz {
    @Id
    @Column(name = "Clazz_code", nullable = false, length = 50)
    private String id;

    @Column(name = "ID_Faculty", nullable = false, length = 50)
    private String idFaculty;

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

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}