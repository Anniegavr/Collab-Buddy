package com.backend.collab_backend.administrator;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
  List<AdministratorDTO> getAllAdministrators();
  Administrator getAdministratorByAdministratorId(Long id);
  AdministratorDTO createAdministrator(AdministratorDTO administrator);
  ResponseEntity.BodyBuilder deleteAdministrator(Long id);
}
