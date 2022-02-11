package code.webdkmh.dao.service;

import code.webdkmh.dao.entity.User;
import code.webdkmh.dao.repository.PasswordResetTokenRepository;
import code.webdkmh.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> getUserByPasswordResetToken(String token) {
        String userID = passwordResetTokenRepository.findByToken(token).getId();
        return userRepository.findById(userID);
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
