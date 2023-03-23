package com.collab.buddy.administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    @Transactional
    @Modifying
    @Query("update Administrator a set a.age = :age")
    Administrator updateAgeBy(@Param("age") Integer age);
}
