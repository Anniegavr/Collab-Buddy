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
    public ResponseEntity<Administrator> getAdministratorByAdministratorId(@PathVariable Long id) {
        Administrator administrator = administratorService.getAdministratorByAdministratorId(id);
        if (administrator == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administrator);
    }

    @PostMapping
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return administratorService.createAdministrator(administrator);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody int administratorAge) {
        Administrator updatedAdministrator = administratorService.updateAdministrator(id, administratorAge);
        if (updatedAdministrator == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAdministrator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        if (administratorService.getAdministratorByAdministratorId(id) == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}

