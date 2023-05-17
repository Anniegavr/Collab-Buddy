package com.backend.collab_backend.student;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
  private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
  private final StudentRepository studentRepository;

  public StudentDTO convertRealToDTOStudent(Student student) {
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.firstName = student.getFirstName();
    studentDTO.lastName = student.getLastName();
    studentDTO.email = student.getEmail();
    studentDTO.specialty = student.getSpecialty();
    studentDTO.year = Integer.toString(student.getYear());
    return studentDTO;
  }

  public Student convertDTOtoRealStudent(StudentDTO studentDTO) {
    Student student = new Student();
    student.setFirstName(studentDTO.firstName);
    student.setLastName(studentDTO.lastName);
    student.setEmail(studentDTO.email);
    student.setSpecialty(studentDTO.specialty);
    student.setYear(Integer.parseInt(studentDTO.year));
    return student;
  }

  @Override
  public List<StudentDTO> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    List<StudentDTO> studentDTOs = new ArrayList<>();

    for (Student student : students) {
      studentDTOs.add(convertRealToDTOStudent(student));
    }

    return studentDTOs;
  }


  @Override
  public StudentDTO getStudentById(Long id) {
    Student student = studentRepository.findStudentById(id).orElseGet(Student::new);
    return convertRealToDTOStudent(student);
  }

  @Override
  public StudentDTO createStudent(StudentDTO student) {
    Student student1 = convertDTOtoRealStudent(student);
    studentRepository.save(student1);
    return student;
  }

  @Override
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }

  @Override
  public StudentDTO updateStudent(Long id, StudentDTO student){
    Optional<Student> studentToUpdate = studentRepository.findStudentById(id);
    if(studentToUpdate.isEmpty()){
      return new StudentDTO();
    }
    studentRepository.deleteById(studentToUpdate.get().getId());
    Student studentToUpdateNew = convertDTOtoRealStudent(student);
    studentToUpdateNew.setId(id);
    studentRepository.save(studentToUpdateNew);
    return student;
  }
}