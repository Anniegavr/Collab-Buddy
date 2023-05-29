package com.backend.collab_backend.config;


import com.backend.collab_backend.AbstractUser;
import com.backend.collab_backend.config.authentication.jwt.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AbstractUser> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.get().getUsername())
                .password(user.get().getPassword())
                .roles(user.get().getRole())
                .roles(user.get().getSecondRole())
                .roles(user.get().getThirdRole())
                .build();
    }


//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException(String.format("User Not Found with username: [%s]", username)));
//        return UserDetailsImpl.build(user);
//    }
}
