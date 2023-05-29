package com.backend.collab_backend.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student_groups")
public class StudentGroupController {
  @GetMapping("/all")
  public ResponseEntity<List<StudentGroup>> getAllGroups(){
    List<StudentGroup> groups = new ArrayList<>();

    groups.add(new StudentGroup(1L, "Group 1", 2021, "group1@example.com", "Specialty 1"));
    groups.add(new StudentGroup(2L, "Group 2", 2022, "group2@example.com", "Specialty 2"));
    groups.add(new StudentGroup(3L, "Group 3", 2023, "group3@example.com", "Specialty 3"));
    groups.add(new StudentGroup(4L, "Group 4", 2024, "group4@example.com", "Specialty 4"));
    return ResponseEntity.ok(groups);
  }
}
