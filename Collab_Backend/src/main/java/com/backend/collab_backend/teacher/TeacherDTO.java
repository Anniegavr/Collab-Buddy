
package com.backend.collab_backend.teacher;

import com.backend.collab_backend.AbstractUser;
import com.backend.collab_backend.role.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TeacherDTO extends AbstractUser {
  private List<String> courses;
  private static ERole role = ERole.TEACHER;

}
