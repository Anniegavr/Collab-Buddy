package com.collab.buddy.administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    @Modifying
    @Transactional
    @Query("update Administrator a set a.username = :name, a.email = :email, a.password = :password where a.id = :id")
    void updateAdministrator(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("password") String password);

    Optional<Administrator> findAdministratorById(Long id);
}
