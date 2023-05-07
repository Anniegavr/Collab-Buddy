package com.collab.buddy.administrator;

import com.collab.buddy.config.role.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Administrator extends AbstractUser {
  @Column(name = "specialty", nullable = false)
  private String specialty;

  @Column(name = "role", nullable = false)
  private static ERole role = ERole.ADMIN;

}