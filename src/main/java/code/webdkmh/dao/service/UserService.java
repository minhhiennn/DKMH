package code.webdkmh.dao.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import code.webdkmh.dao.custom.CustomUserDetail;
import code.webdkmh.dao.entities.Users;
import code.webdkmh.dao.repositories.PasswordResetTokenRepository;
import code.webdkmh.dao.repositories.UsersRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

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

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Users user = findById(id);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserHasRole().getIdUserKind()));
        System.out.println(user.getUserHasRole().getIdUserKind());
        System.out.println(user.getStudent().getIdStudent());
        CustomUserDetail userDetail = new CustomUserDetail();
        userDetail.setUsers(user);
        userDetail.setAuthorities(grantedAuthorities);
        return userDetail;
    }
}
