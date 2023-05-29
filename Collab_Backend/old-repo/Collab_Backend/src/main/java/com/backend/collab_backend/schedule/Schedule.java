//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.backend.collab_backend.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
  @SequenceGenerator(
          name="schedule_sequence",
          sequenceName = "schedule_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "schedule_sequence"
  )
  @Id
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  @Column(nullable = false)
  private String description;

  //  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "student_id", nullable = false)
  @Column(name = "student_id")
  private Long studentId;

}