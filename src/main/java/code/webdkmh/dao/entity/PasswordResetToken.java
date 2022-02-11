package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {
    @Id
    @Column(name = "ID_User", nullable = false, length = 50)
    private String id;

    @Column(name = "token", nullable = false, length = 50)
    private String token;

    @Column(name = "expiry_Date", nullable = false)
    private Instant expiryDate;

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}