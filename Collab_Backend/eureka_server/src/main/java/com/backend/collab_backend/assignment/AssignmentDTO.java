package com.backend.collab_backend.assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
public class AssignmentDTO {
  public String course;
  public String title;
  public String description;
  public String group;
  public String type;

  //Estimated total allocated time
  public String time;
  public LocalDate dueDate;
  public String teacherName;
}