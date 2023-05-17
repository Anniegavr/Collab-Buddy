package com.backend.collab_backend.student;

import com.backend.collab_backend.AbstractUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends AbstractUser {
  @Column(name = "year", nullable = false)
  private Integer year;
  @Column(name="specialty", nullable = false)
  private String specialty;
}
