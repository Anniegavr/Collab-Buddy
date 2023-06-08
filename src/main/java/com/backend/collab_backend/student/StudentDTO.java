package com.backend.collab_backend.student;

import com.backend.collab_backend.role.ERole;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentDTO {
  public Long id;
  public String firstName;
  public  String lastName;
  public String group;
  public String email;
  public  String specialty;
  public String year;
  public String role = ERole.STUDENT.name();
}
