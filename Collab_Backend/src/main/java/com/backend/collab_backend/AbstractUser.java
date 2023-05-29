package com.backend.collab_backend;

import com.backend.collab_backend.role.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser implements Serializable {

  @SequenceGenerator(
          name="id_sequence",
          sequenceName = "id_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "id_sequence"
  )
  @Id
  private Long id;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  @Column(name="username", nullable = true, unique = true)
  private String username;

  private String role;

  private String secondRole;
  private String thirdRole;
}
