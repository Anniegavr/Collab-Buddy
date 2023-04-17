package com.collab.buddy.administrator;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
    List<Administrator> getAllAdministrators();
    AdministratorDTO getAdministratorByAdministratorId(Long id);
    AdministratorDTO createAdministrator(Administrator administrator);
    AdministratorDTO updateAdministrator(Administrator administrator);
    ResponseEntity.BodyBuilder deleteAdministrator(Long id);
}
