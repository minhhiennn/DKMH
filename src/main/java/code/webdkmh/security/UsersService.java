package code.webdkmh.security;

import code.webdkmh.dao.entities.Users;
import code.webdkmh.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UsersService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Users user = userService.findById(id);

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
