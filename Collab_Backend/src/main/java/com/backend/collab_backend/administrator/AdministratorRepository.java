package com.backend.collab_backend.administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
  void deleteAdministratorById(Long id);
}
