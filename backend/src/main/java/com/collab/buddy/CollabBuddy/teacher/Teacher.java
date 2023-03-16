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
public class Teacher {
    @Id
    @SequenceGenerator(
            name="teacher_id_sequence",
            sequenceName = "teacher_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_id_sequence"
    )
    private Long teacherId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "courses", nullable = false)
    private String courses;

    @Column(name = "role", nullable = false)
    private static ERole role = ERole.TEACHER;
}