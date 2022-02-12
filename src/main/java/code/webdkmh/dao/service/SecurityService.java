package code.webdkmh.dao.service;

import code.webdkmh.dao.entities.PasswordResetToken;
import code.webdkmh.dao.repositories.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class SecurityService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public String valiDatePasswordResetToken(String token) {
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
        // Is that moment (a) not before 24 hours ago, AND (b) before now (not in the
        // future)?
        Boolean within24Hours = (!passToken.getExpiryDate().toInstant().isBefore(twentyFourHoursEarlier))
                && passToken.getExpiryDate().toInstant().isBefore(now);
        return !within24Hours;
    }
}
