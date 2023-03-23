package com.collab.buddy.teacher;

import com.collab.buddy.config.role.ERole;
import com.collab.buddy.general.user.AbstractUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDTO extends AbstractUser {
    private List<String> courses;
    private static ERole role = ERole.TEACHER;

}
