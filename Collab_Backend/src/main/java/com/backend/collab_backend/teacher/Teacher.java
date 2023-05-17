package com.backend.collab_backend.teacher;

import com.backend.collab_backend.AbstractUser;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Teacher extends AbstractUser {
  @ElementCollection
  private List<String> courses;

}
