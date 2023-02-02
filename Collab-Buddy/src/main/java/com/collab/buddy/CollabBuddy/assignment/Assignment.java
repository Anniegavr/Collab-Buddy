package com.collab.buddy.CollabBuddy.assignment;

import com.collab.buddy.CollabBuddy.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDate;



@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EnableJpaRepositories
public class Assignment {
    @Id
    @SequenceGenerator(
            name="assignment_id_sequence",
            sequenceName = "assignment_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "assignment_id_sequence"
    )
    private Long assignmentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
