package com.backend.collab_backend.student.progress;

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
public class Progress {
  @SequenceGenerator(
          name="progress_sequence",
          sequenceName = "progress_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "progress_sequence"
  )
  @Id
  private Long id;

  private Long studentId;
  private Long assignmentId;
  private String taskName;
  private int taskProgress;
}
