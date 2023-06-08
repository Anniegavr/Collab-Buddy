package com.backend.collab_backend.assignment.to.schedule;

import com.backend.collab_backend.student.StudentController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AssignmentToScheduleController {
  private static final Logger logger = LoggerFactory.getLogger(AssignmentToScheduleController.class);



}
