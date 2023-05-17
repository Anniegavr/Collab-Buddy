package com.backend.collab_backend.assignment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class AssignmentDTO {
  private String course;
  private String title;
  private String description;
  private String group;
  private String type;

  //Estimated total allocated time
  private String time;
  private LocalDate dueDate;
  private String teacherName;
}