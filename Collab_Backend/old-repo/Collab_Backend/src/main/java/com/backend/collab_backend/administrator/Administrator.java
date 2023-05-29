package com.backend.collab_backend.administrator;

import com.backend.collab_backend.AbstractUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Administrator extends AbstractUser {
  @Column(name = "specialty", nullable = false)
  private String specialty;

}
