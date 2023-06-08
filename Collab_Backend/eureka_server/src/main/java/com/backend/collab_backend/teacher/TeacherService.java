package com.backend.collab_backend.teacher;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
  List<TeacherDTO> getAllTeachers();
  TeacherDTO getTeacherByTeacherId(Long id);
  ResponseEntity<String> createTeacher(TeacherDTO teacher);
  ResponseEntity<TeacherDTO> updateTeacher(Long id, TeacherDTO teacher);
  void deleteTeacher(Long id);
}
