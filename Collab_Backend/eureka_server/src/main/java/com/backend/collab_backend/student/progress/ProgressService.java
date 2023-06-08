package com.backend.collab_backend.student.progress;

import java.util.List;

public interface ProgressService {
  List<ProgressDTO> findAllForStudent(Long id);
  ProgressDTO recordProgressForStudent(Long id, ProgressDTO progress);

}
