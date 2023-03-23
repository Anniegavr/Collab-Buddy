package com.collab.buddy.teacher;

import com.collab.buddy.config.role.ERole;
import com.collab.buddy.general.user.AbstractUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends AbstractUser {
    @ElementCollection
    private List<String> courses;

    @Column(name = "role", nullable = false)
    private static ERole role = ERole.TEACHER;
}
