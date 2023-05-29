package com.backend.collab_backend.administrator;

import com.backend.collab_backend.role.ERole;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdministratorDTO {
  public String firstName;
  public String lastName;
  public String email;
  public Integer age;
  public  String role = ERole.ADMIN.name();
  public String secondRole;
  public String thirdRole;
  public String specialty;

}
