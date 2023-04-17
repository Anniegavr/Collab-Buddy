package com.collab.buddy.administrator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorServiceImpl administratorService;

    @GetMapping
    public List<Administrator> getAllAdministrators() {
        return administratorService.getAllAdministrators();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministratorDTO> getAdministratorByAdministratorId(@PathVariable Long id) {
        AdministratorDTO administrator = administratorService.getAdministratorByAdministratorId(id);

        if (administrator == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(administrator);
    }

    @PostMapping
    public AdministratorDTO createAdministrator(@RequestBody Administrator administrator) {
        return administratorService.createAdministrator(administrator);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministratorDTO> updateAdministrator(Administrator administrator) {
        AdministratorDTO updatedAdministrator = administratorService.updateAdministrator(administrator);
        if (updatedAdministrator == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAdministrator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteAdministrator(@PathVariable Long id) {
        return administratorService.deleteAdministrator(id);
    }
}

