package com.backend.collab_backend.student.group;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/student_groups")
public class StudentGroupController {
  private final StudentGroupService studentGroupService;
  @GetMapping("/all")
  public ResponseEntity<List<StudentGroupDTO>> getAllGroups(){
    List<StudentGroupDTO> groups = studentGroupService.getAllGroups();

    if (groups.isEmpty()) {
      groups.add(new StudentGroupDTO( "FAF-191", "faf-191fcim@UTM.onmicrosoft.com", "Software Engineering", 2019, 2, 5, 4));
      groups.add(new StudentGroupDTO( "FAF-192", "faf-192fcim@UTM.onmicrosoft.com", "Software Engineering", 2019, 2, 5, 4));
      groups.add(new StudentGroupDTO( "FAF-193", "faf-193fcim@UTM.onmicrosoft.com", "Software Engineering", 2019, 2, 5, 4));
      groups.add(new StudentGroupDTO("FAF-194", "faf-194fcim@UTM.onmicrosoft.com", "Software Engineering", 2019, 2, 5, 4));
    }

    return ResponseEntity.ok(groups);
  }
}
