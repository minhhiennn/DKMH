package code.webdkmh.dao.service;

import code.webdkmh.dao.entities.Users;
import code.webdkmh.dao.repositories.PasswordResetTokenRepository;
import code.webdkmh.dao.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Users findById(String id) {
        return userRepository.findById(id).get();
    }

    public Optional<Users> getUserByPasswordResetToken(String token) {
        String userID = passwordResetTokenRepository.findByToken(token).getIdUser();
        return userRepository.findById(userID);
    }

    public void changeUserPassword(Users user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
