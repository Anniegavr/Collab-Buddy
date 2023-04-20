package com.collab.buddy.student;

import org.springframework.http.ResponseEntity;

import java.util.List;


public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);

    StudentDTO createStudent(Student student);
    ResponseEntity.BodyBuilder deleteStudent(Long id);

    StudentDTO updateStudent(Long id, StudentDTO student) throws Exception;
}