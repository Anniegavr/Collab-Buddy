package com.backend.collab_backend.administrator;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
  List<AdministratorDTO> getAllAdministrators();
  Administrator getAdministratorByAdministratorId(Long id);
  Administrator createAdministrator(AdministratorDTO administrator);
  Administrator updateAdministrator(Long id, int administratorAge);
  ResponseEntity.BodyBuilder deleteAdministrator(Long id);
}
