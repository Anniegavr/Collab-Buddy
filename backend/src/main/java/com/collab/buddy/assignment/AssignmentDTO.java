package com.collab.buddy.assignment;

import com.collab.buddy.teacher.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDTO {
    private String name;
    private String description;
    private LocalDate dueDate;
    private String teacherName;
}
