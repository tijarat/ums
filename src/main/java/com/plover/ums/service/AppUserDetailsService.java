package com.plover.ums.service;

import com.plover.ums.entity.UserEntity;
import com.plover.ums.repo.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        Set<String> authorities = new HashSet<>();

    if (user.getRoles() != null) {
        user.getRoles().forEach(role -> {
            authorities.add("ROLE_" + role.getRoleName());
            System.out.println("Loaded Role: " + role.getRoleName()); // DEBUG

            if (role.getRights() != null) {
                role.getRights().forEach(right -> {
                    authorities.add(right.getRightName());
                    System.out.println("Loaded Right: " + right.getRightName()); // DEBUG
                });
            }
        });
    }

        return User.withUsername(user.getUsername())
                   .password(user.getPassword())
                   .authorities(authorities.toArray(new String[0]))
                   .disabled(user.getActiveInd() == null ? false : user.getActiveInd() != 1)
                   .build();
    }


}

