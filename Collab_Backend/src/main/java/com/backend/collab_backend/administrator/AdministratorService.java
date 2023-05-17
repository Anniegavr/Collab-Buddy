package com.backend.collab_backend.administrator;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
  List<Administrator> getAllAdministrators();
  Administrator getAdministratorByAdministratorId(Long id);
  Administrator createAdministrator(Administrator administrator);
  Administrator updateAdministrator(Long id, int administratorAge);
  ResponseEntity.BodyBuilder deleteAdministrator(Long id);
}
