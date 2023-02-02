package com.collab.buddy.CollabBuddy.student;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);

    Student createStudent(Student student);
    void deleteStudent(Long id);

    Student updateStudent(Long id, Student student) throws Exception;
}