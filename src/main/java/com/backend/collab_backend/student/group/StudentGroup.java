package com.backend.collab_backend.student.group;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class StudentGroup {
  @SequenceGenerator(
          name="group_sequence",
          sequenceName = "group_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "group_sequence"
  )
  @Id
  private Long id;
  @Column(unique = true)
  private String name;
  private int year;
  private String email;
  private String specialty;
  private int startYear;
  private int freeTime;
  private int tripTime;
}
