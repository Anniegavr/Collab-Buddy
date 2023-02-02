package com.collab.buddy.CollabBuddy.administrator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService{
    private final AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getAdministratorByAdministratorId(Long id) {
        return administratorRepository.findById(id).get();
    }

    @Override
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Administrator updateAdministrator(Long id, int age) {
        return administratorRepository.updateAgeBy(age);
    }

    @Override
    public ResponseEntity.BodyBuilder deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
        return ResponseEntity.ok();
    }
}
