package com.backend.collab_backend.student.skill.accomplishment;

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
public class Accomplishment {
  @SequenceGenerator(
          name="stud_skill_id_sequence",
          sequenceName = "stud_skill_id_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "stud_skill_id_sequence"
  )
  @Id
  private Long id;

  private Long studentId;
  @Column(unique = true)
  private String skillType;

  private String studentAccomplishment;
}
