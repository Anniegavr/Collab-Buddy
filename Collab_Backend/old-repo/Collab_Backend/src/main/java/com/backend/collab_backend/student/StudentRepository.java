package com.backend.collab_backend.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Optional<Student> findStudentById(Long id);
  Optional<List<Student>> findAllByFirstNameContaining(String name);
  Optional<List<Student>> findAllByLastNameContaining(String name);
  Optional<List<Student>> findAllByEmailContaining(String name);
}
