package com.backend.collab_backend.administrator;

import com.backend.collab_backend.role.ERole;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdministratorDTO {
  public Long id;
  public String firstName;
  public String lastName;
  public String email;
  public  String role = ERole.ADMIN.name();
  public String secondRole;
  public String thirdRole;
  public String specialty;

  public String username;

}
