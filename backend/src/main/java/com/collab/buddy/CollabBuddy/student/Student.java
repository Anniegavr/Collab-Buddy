package com.collab.buddy.CollabBuddy.student;

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
public class Student extends  AbstractUser{
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name="specialty", nullable = false)
    private String specialty;
    @Column(name = "role", nullable = false)
    private static ERole role = ERole.STUDENT;
}

