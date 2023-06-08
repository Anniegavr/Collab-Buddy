package com.backend.collab_backend.administrator;

import com.backend.collab_backend.assignment.EAssignmentType;
import com.backend.collab_backend.student.StudentDTO;
import com.backend.collab_backend.student.StudentService;
import com.backend.collab_backend.teacher.TeacherDTO;
import com.backend.collab_backend.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
  private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
  private final AdministratorService administratorService;
  private final StudentService studentService;
  private final TeacherService teacherService;
  @PostMapping("/add_admin")
  public ResponseEntity<AdministratorDTO> createAdministrator(@RequestBody AdministratorDTO administratorDTO) {
    logger.info("Creating new administrator: {}", administratorDTO);
    AdministratorDTO administratorDTO1 = administratorService.createAdministrator(administratorDTO);
    logger.info("New administrator created successfully: [{}]", administratorDTO);
    return ResponseEntity.ok(administratorDTO1);
  }
  @PutMapping("/update_teacher/{id}")
  public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
    TeacherDTO teacherDTO1 = teacherService.updateTeacher(id, teacherDTO).getBody();
    if(!teacherDTO1.equals(new TeacherDTO())) {
      logger.info("Teacher with ID {} updated", id);
      return ResponseEntity.ok(teacherDTO1);
    }
    logger.info("Student with ID {} not found", id);
    return ResponseEntity.noContent().build();
  }
  @PostMapping("/add_teacher")
  public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacher) {
    logger.info("Creating new teacher: {}", teacher);
    teacherService.createTeacher(teacher);
    logger.info("New teacher created successfully: [{}]", teacher);
    return ResponseEntity.ok(teacher);
  }
  @PostMapping("/add_student")
  public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
    logger.info("Creating new student: {} {}", student.firstName, student.lastName);
    return ResponseEntity.ok(studentService.createStudent(student));
  }
  @PutMapping("/update_student/{id}")
  public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO student) {
    StudentDTO studentDTO = studentService.updateStudent(id, student);
    if(!studentDTO.equals(new StudentDTO())) {
      logger.info("Student with ID {} updated", id);
      return ResponseEntity.ok(studentDTO);
    }
    logger.info("Student with ID {} not found", id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/assignment_types")
  public ResponseEntity<List<EAssignmentType>> getAllAssignmentTypes() {
    logger.info("Getting all assignment types");
    List<EAssignmentType> assignmentTypes = new ArrayList<>();
    assignmentTypes.add(EAssignmentType.LAB);
    assignmentTypes.add(EAssignmentType.PROJECT);
    assignmentTypes.add(EAssignmentType.READING);
    logger.info("Returning all assignment types: {}", assignmentTypes);
    return ResponseEntity.ok(assignmentTypes);
  }

  @PutMapping("/assignment_types/edit")
  public ResponseEntity<List<String>> editAssignmentType(@RequestBody String assignmentType, @RequestBody String newAssignmentType) {
    String assignmentTypeOld = EAssignmentType.valueOf(assignmentType).name();
    List<String> newList = new ArrayList<>();
    newList.add(EAssignmentType.LAB.name());
    newList.add(EAssignmentType.PROJECT.name());
    newList.add(EAssignmentType.READING.name());
    newList.add(newAssignmentType);
    newList.remove(assignmentTypeOld);
    logger.info("Assignment type updated from {} to {}", assignmentTypeOld, newAssignmentType);
    return ResponseEntity.ok(newList);
  }
  @PostMapping("/assignment_types/add")
  public ResponseEntity<List<String>> addAssignmentType(@RequestBody String newAssignmentType) {
    List<String> newList = new ArrayList<>();
    newList.add(EAssignmentType.LAB.name());
    newList.add(EAssignmentType.PROJECT.name());
    newList.add(EAssignmentType.READING.name());
    newList.add(newAssignmentType.replace('=', ' '));
    logger.info("Assignment type added: {}", newAssignmentType);
    return ResponseEntity.ok(newList);
  }

  @PostMapping("/auth/signin")
  public ResponseEntity<String> authenticateUser(@RequestBody String request) {
    System.out.println("Got request for "+request);
    return ResponseEntity.ok("Success");
  }
  @DeleteMapping("/del_student/{id}")
  public void deleteStudent(@PathVariable Long id) {
    logger.info("Deleting student with ID {}", id);
    studentService.deleteStudent(id);
  }
  @GetMapping("/all_admins")
  public ResponseEntity<List<AdministratorDTO>> getAllAdministrators() {
    logger.info("Received request to get all administrators");
    return ResponseEntity.ok(administratorService.getAllAdministrators());
  }
  @GetMapping("/requests/total")
  public ResponseEntity<String> getTotalWebsiteRequests() {
    logger.info("Received request to get total website requests");
    return ResponseEntity.ok("3,489,744");
  }
  @GetMapping("/admin/{id}")
  public ResponseEntity<String> getAdministratorByAdministratorId(@PathVariable Long id) {
    logger.info("Received request to get administrator by ID: {}", id);
    administratorService.getAdministratorByAdministratorId(id);
    return ResponseEntity.ok("JonathanD: Dean, HR Manager");
  }
  @DeleteMapping("/delete_admin/{id}")
  public ResponseEntity<String> deleteAdministrator(@PathVariable Long id) {
    administratorService.deleteAdministrator(id);
    logger.info("Received request to delete administrator with ID: {}", id);
    return ResponseEntity.ok("Success, you deleted admin with ID "+id);
  }
}
