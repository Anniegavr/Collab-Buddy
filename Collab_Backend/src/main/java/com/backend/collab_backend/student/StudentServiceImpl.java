package com.backend.collab_backend.student;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public Student getStudentById(Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("students.Student not found with id : " + id));
  }

  @Override
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }

  @Override
  public Student updateStudent(Long id, Student student) throws Exception {
    Student studentToUpdate = (Student) studentRepository.findStudentById(id)
            .orElseThrow(() -> new Exception("students.Student not found with id : " + id));

//        studentToUpdate.setFirstName(student.getName());
    studentToUpdate.setAge(student.getAge());
    studentToUpdate.setEmail(student.getEmail());

    return studentRepository.save(studentToUpdate);
  }
}
