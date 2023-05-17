package com.backend.collab_backend.assignment;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDate;
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EnableJpaRepositories
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

  @Column(name = "course", nullable = false)
  private String course;
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "groups", nullable = false)
  private String groups;
  @Column(name = "type", nullable = false)
  private String type;
  @Column(name = "time", nullable = false)
  private String time;
  @Column(name = "teacher_name", nullable = false)
  private String teacherName;

  @Column(name = "due_date", nullable = false)
  private LocalDate dueDate;

  //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_id", nullable = false)
  @Column(name = "teacher_id")
  private Long teacherId;
}