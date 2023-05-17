package com.backend.collab_backend.student;

public class StudentGroup {
  public long id;
  public String name;
  public int year;
  public String email;
  public String specialty;

  public StudentGroup(long id, String name, int year, String email, String specialty) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.email = email;
    this.specialty = specialty;
  }
}
