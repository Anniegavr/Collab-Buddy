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
    studentDTO.id = student.getId();
    studentDTO.firstName = student.getFirstName();
    studentDTO.lastName = student.getLastName();
    studentDTO.group = student.getGroupId();
    studentDTO.email = student.getEmail();
    studentDTO.specialty = student.getSpecialty();
    studentDTO.year = Integer.toString(student.getYear());
    return studentDTO;
  }

  public Student convertDTOtoRealStudent(StudentDTO studentDTO) {
    Student student = new Student();
    student.setFirstName(studentDTO.firstName);
    student.setLastName(studentDTO.lastName);
    student.setGroupId(studentDTO.group);
    student.setEmail(studentDTO.email);
    student.setSpecialty(studentDTO.specialty);
    student.setYear(Integer.parseInt(studentDTO.year));
    return student;
  }

  @Override
  public List<StudentDTO> getAllStudents() {

    List<Student> students = studentRepository.findAll();
    List<StudentDTO> studentDTOs = new ArrayList<>();
    logger.info("Get all students: found [{}] students.", students.size());
    for (Student student : students) {
      studentDTOs.add(convertRealToDTOStudent(student));
    }

    return studentDTOs;
  }


  @Override
  public StudentDTO getStudentById(Long id) {
    Student student = studentRepository.findStudentById(id).orElseGet(Student::new);
    logger.info("Searching for student_id[{}] returned [{}] [{}]", id, student.getFirstName(), student.getLastName());
    return convertRealToDTOStudent(student);
  }

  @Override
  public StudentDTO createStudent(StudentDTO student) {
    Student student1 = convertDTOtoRealStudent(student);
    student1.setUsername(student1.getFirstName().toLowerCase().charAt(0)+student1.getLastName().toLowerCase());
    logger.info("Saving new student with username [{}]", student1.getUsername());
    studentRepository.save(student1);
    return student;
  }

  @Override
  public void deleteStudent(Long id) {
    logger.info("Deleting student with id [{}] and email [{}]", id, studentRepository.findStudentById(id).get().getEmail());
    studentRepository.deleteStudentById(id);
  }

  @Override
  public StudentDTO updateStudent(Long id, StudentDTO student){
    Optional<Student> studentToUpdate = studentRepository.findStudentById(id);
    if(studentToUpdate.isEmpty()){
      logger.info("Updating student: couldn't find student with id[{}] and email[{}]", id, student.email);
      return new StudentDTO();
    }
    studentRepository.deleteById(studentToUpdate.get().getId());
    Student studentToUpdateNew = convertDTOtoRealStudent(student);
    studentToUpdateNew.setId(id);
    logger.info("Updating student with id[{}] and email[{}]. New email (if changed): {}", id, student.email, studentToUpdate.get().getEmail());
    studentRepository.save(studentToUpdateNew);
    return student;
  }
}
