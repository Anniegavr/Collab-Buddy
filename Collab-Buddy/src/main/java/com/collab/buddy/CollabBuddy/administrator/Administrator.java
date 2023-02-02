package com.collab.buddy.CollabBuddy.administrator;

import com.collab.buddy.CollabBuddy.config.role.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Administrator {
    @Id
    @SequenceGenerator(
            name="admin_id_sequence",
            sequenceName = "admin_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_id_sequence"
    )
    private Long adminId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "specialty", nullable = false)
    private String specialty;

    @Column(name = "role", nullable = false)
    private static ERole role = ERole.ADMIN;

}
