package com.backend.collab_backend.config.authentication.jwt.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String jwt;
    private Long id;
    private String username;
    private String email;
}
