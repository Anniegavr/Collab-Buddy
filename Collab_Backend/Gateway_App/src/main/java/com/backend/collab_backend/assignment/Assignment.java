package com.backend.collab_backend.assignment;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDate;
@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Assignment {
  @Id
  @SequenceGenerator(
          name="assignment_id_sequence",
          sequenceName = "assignment_id_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "assignment_id_sequence"
  )
  private Long assignmentId;

  @Column(nullable = false)
  private String course;
  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String groupId;
  @Column(nullable = false)
  private String type;
  @Column(nullable = false)
  private String time;
  @Column(nullable = false)
  private String teacherName;

  @Column(nullable = false)
  private LocalDate dueDate;

}