package com.collab.buddy.general.user;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractUser implements Serializable {
  @Id
  @SequenceGenerator(
          name="student_id_sequence",
          sequenceName = "student_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "student_id_sequence"
  )
  private Long studentId;
  @Column(name="password", nullable = false)
  private String password;

  @Column(name="first_name", nullable = false)
  private String firstName;

  @Column(name="last_name", nullable = false)
  private String lastName;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name="email", nullable = false)
  private String email;

  @Column(name="username", nullable = false, unique = true)
  private String username;
}

