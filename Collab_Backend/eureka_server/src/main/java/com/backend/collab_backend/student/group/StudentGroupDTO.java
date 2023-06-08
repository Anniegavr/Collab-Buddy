package com.backend.collab_backend.student.group;

public class StudentGroupDTO {
  public String name;
  public String email;
  public String specialty;
  public int startYear;
  public int tripTime;
  public int freeTime;
  public int year;

  public StudentGroupDTO(String name,
                         String email,
                         String specialty,
                         int startYear,
                         int tripTime,
                         int freeTime,
                         int year) {
    this.name = name;
    this.email = email;
    this.specialty = specialty;
    this.startYear = startYear;
    this.tripTime = tripTime;
    this.freeTime = freeTime;
    this.year = year;
  }
}
