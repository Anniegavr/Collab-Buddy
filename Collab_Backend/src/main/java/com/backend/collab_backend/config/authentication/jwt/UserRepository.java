package com.backend.collab_backend.config.authentication.jwt;

import com.backend.collab_backend.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AbstractUser, Long> {
    boolean existsByUsername(String username);
    Optional<AbstractUser> findUserByUsername(String username);

    Optional<AbstractUser> findUserByUsernameAndPassword(String username, String passwd);
}
