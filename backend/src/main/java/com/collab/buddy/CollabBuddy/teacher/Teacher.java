package com.collab.buddy.CollabBuddy.teacher;

import com.collab.buddy.CollabBuddy.config.role.ERole;
import jakarta.persistence.*;
import lombok.*;


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
