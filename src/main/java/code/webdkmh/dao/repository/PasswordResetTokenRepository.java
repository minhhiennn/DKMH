package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {

    PasswordResetToken findByToken(String token);
}