package code.webdkmh.dao.service;

import code.webdkmh.dao.entity.PasswordResetToken;
import code.webdkmh.dao.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class SecurityService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        Instant now = Instant.now();
        Instant twentyFourHoursEarlier = now.minus(24, ChronoUnit.HOURS);
        // Is that moment (a) not before 24 hours ago, AND (b) before now (not in the future)?
        Boolean within24Hours = (!passToken.getExpiryDate().isBefore(twentyFourHoursEarlier)) && passToken.getExpiryDate().isBefore(now);
        return !within24Hours;
    }
}
