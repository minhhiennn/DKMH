package code.webdkmh.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "ID_User", nullable = false, length = 50)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_User_Kind", nullable = false)
    private UserKind idUserKind;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserKind getIdUserKind() {
        return idUserKind;
    }

    public void setIdUserKind(UserKind idUserKind) {
        this.idUserKind = idUserKind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}