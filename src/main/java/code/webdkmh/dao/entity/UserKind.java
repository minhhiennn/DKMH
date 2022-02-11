package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_KIND")
public class UserKind {
    @Id
    @Column(name = "ID_User_Kind", nullable = false, length = 2)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}