package com.backend.collab_backend.student.skill.accomplishment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/accomplishments")
public class AccomplishmentController {
  private final AccomplishmentService accomplishmentService;
  @GetMapping("/{studentId}")
  public List<Accomplishment> findAllForStudent(@PathVariable("studentId") Long studentId) {
    return accomplishmentService.findByStudent(studentId);
  }
}
