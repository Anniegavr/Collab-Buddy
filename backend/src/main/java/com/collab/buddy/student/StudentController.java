package com.collab.buddy.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
        StudentDTO studentDTO = studentService.createStudent(student);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO student) throws Exception {
        StudentDTO studentDTO = studentService.updateStudent(id, student);
        return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
