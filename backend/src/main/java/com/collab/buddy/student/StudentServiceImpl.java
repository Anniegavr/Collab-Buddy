package com.collab.buddy.student;

import com.collab.buddy.config.authentication.jwt.AuthTokenFilter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(student.getFirstName()+student.getLastName(),
                                                   student.getYear(),
                                                   student.getSpecialty(),
                                                   student.getEmail());
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student foundStudent = studentRepository.findById(id)
                .orElseGet(Student::new);
        return new StudentDTO(foundStudent.getFirstName()+foundStudent.getLastName(),
                              foundStudent.getYear(), foundStudent.getSpecialty(), foundStudent.getEmail());

    }

    @Override
    public StudentDTO createStudent(Student student) {
        Student student1 = studentRepository.save(student);
        return new StudentDTO(student1.getFirstName()+student1.getLastName(),
                              student1.getYear(),
                              student1.getSpecialty(),
                              student1.getEmail());
    }

    @Override
    public ResponseEntity.BodyBuilder deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok();
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO student) throws Exception {
        Student studentToUpdate = (Student) studentRepository.findStudentByStudentId(id)
                .orElseThrow(() -> new Exception("students.Student not found with id : " + id));

        studentToUpdate.setYear(student.year);
        studentToUpdate.setSpecialty(student.specialty);
        studentToUpdate.setEmail(student.email);
        try {
            studentRepository.save(studentToUpdate);
        } catch (Exception e) {
            logger.error("Could not update student {[]}, cause {}", studentToUpdate, e);
            return student;
        }

        return student;
    }
}