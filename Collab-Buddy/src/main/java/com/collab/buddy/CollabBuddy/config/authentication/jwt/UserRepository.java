package com.collab.buddy.CollabBuddy.config.authentication.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUsernameAndPassword(String username, String passwd);
}
