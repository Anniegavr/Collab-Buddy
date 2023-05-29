package com.backend.collab_backend.student.progress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
  List<Progress> findAllByStudentId(Long id);
  Optional<Progress> findProgressByAssignmentId(Long assgnId);
}
