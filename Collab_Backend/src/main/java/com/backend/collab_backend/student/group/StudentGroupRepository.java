package com.backend.collab_backend.student.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, String> {
  List<StudentGroup> findAllByNameContaining(String name);
  StudentGroup findStudentGroupByName(String name);
}
