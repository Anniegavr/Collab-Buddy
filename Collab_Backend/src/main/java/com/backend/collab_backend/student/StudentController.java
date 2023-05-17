package com.backend.collab_backend.student;

import com.backend.collab_backend.assignment.Progress;
import com.backend.collab_backend.schedule.ScheduleTask;
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
@RequestMapping("/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentController {
  private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
  private final StudentService studentService;

  @GetMapping
  public List<StudentDTO> getAllStudents() {
    logger.info("Getting all students");
    return studentService.getAllStudents();
  }

  @GetMapping("/{id}")
  public StudentDTO getStudentById(@PathVariable Long id) {
    logger.info("Getting student with ID: {}", id);
    return studentService.getStudentById(id);
  }

  @GetMapping("/{id}/schedule")
  public ResponseEntity<List<ScheduleTask>> getAllStudentTasks(@PathVariable Long id) {
    List<ScheduleTask> allTasks = new ArrayList<>();
    allTasks.add(new ScheduleTask("LFPC", 4));
    allTasks.add(new ScheduleTask("PTR", 2));
    allTasks.add(new ScheduleTask( "PR",3));
    allTasks.add(new ScheduleTask("Free Time", 4));
    allTasks.add(new ScheduleTask("Class Time", 3));
    allTasks.add(new ScheduleTask("Trip", 1));
    allTasks.add(new ScheduleTask("Sleep", 7));
    logger.info("Received request to view schedule tasks for student_id {} ",id);
    System.out.println("Received request to view schedule tasks for student_id = "+id);
    return ResponseEntity.ok(allTasks);
  }

  @GetMapping("/{id}/progress")
  public ResponseEntity<List<Progress>> getStudentProgressById(@PathVariable Long id) {
    System.out.println("Received req to see progress for id: "+id);
    List<Progress> progresses = new ArrayList<>();
    progresses.add(new Progress("Math", 90));
    progresses.add(new Progress("Chem", 60));
    progresses.add(new Progress("Rom", 50));
    progresses.add(new Progress("Drom", 30));
    progresses.add(new Progress("Baroom", 70));
    progresses.add(new Progress("Hakuna", 50));
    progresses.add(new Progress("Matana", 50));
    return ResponseEntity.ok(progresses);
  }

}

