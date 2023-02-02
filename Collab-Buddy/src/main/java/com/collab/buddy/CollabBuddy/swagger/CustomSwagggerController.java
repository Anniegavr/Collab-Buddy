package com.collab.buddy.CollabBuddy.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/swagger-custom")
public class CustomSwagggerController {

    @GetMapping(value = "/custom")
    public ResponseEntity custom() {
        return ResponseEntity.ok("Custom Swagger Endpoint Hit");
    }
}
