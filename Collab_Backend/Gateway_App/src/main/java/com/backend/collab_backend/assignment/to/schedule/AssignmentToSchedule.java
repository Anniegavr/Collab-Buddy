package com.backend.collab_backend.assignment.to.schedule;

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
@Getter
@Setter
@RequiredArgsConstructor
public class AssignmentToSchedule {
  @SequenceGenerator(
          name="assign_sch_sequence",
          sequenceName = "assign_sch_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "assign_sch_sequence"
  )
  @Id
  private Long id;
  @Column(nullable = false)
  private Long groupId;
  private Long assignmentId;
  @Column(nullable = false)
  private Long scheduleId;

}
