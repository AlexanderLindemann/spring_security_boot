package com.alexander.spring_security_boot.Service;

import com.alexander.spring_security_boot.model.Role;
import com.alexander.spring_security_boot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UserService extends UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public Role findByRoleName(String role);

    public User findUserById(Long userId);

    public List<User> allUsers();

    public boolean saveUser(User user);

    public boolean deleteUser(Long userId);

    public void updateUser(User user);
}
