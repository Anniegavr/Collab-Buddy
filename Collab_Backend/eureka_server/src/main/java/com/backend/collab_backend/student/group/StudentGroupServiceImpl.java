package com.backend.collab_backend.student.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentGroupServiceImpl implements StudentGroupService {
  private final StudentGroupRepository studentGroupRepository;
  public List<StudentGroupDTO> getAllGroups() {
    List<StudentGroup> allGroups = studentGroupRepository.findAll();
    List<StudentGroupDTO> allGroupsDTOs = new ArrayList<>();
    for (StudentGroup group : allGroups) {
      allGroupsDTOs.add(new StudentGroupDTO(group.getName(),
                                            group.getEmail(),
                                            group.getSpecialty(),
                                            group.getStartYear(),
                                            group.getTripTime(),
                                            group.getFreeTime(),
                                            group.getYear()));
    }
    return allGroupsDTOs;
  }

  public StudentGroupDTO createGroup(StudentGroupDTO group) {
    StudentGroup newGroup = convertDTOToReal(group);
    studentGroupRepository.save(newGroup);
    return group;
  }

  public StudentGroupDTO updateGroup(StudentGroupDTO group) {
    studentGroupRepository.delete(studentGroupRepository.findStudentGroupByName(group.name));
    StudentGroup newGroup = convertDTOToReal(group);
    studentGroupRepository.save(newGroup);
    return group;
  }

  public void deleteGroup(StudentGroupDTO group) {
    studentGroupRepository.delete(studentGroupRepository.findStudentGroupByName(group.name));
  }

  public StudentGroup convertDTOToReal(StudentGroupDTO group) {
    StudentGroup newGroup = new StudentGroup();
    newGroup.setName(group.name);
    newGroup.setSpecialty(group.specialty);
    newGroup.setEmail(group.email);
    newGroup.setStartYear(group.startYear);
    newGroup.setTripTime(group.tripTime);
    newGroup.setFreeTime(group.freeTime);
    newGroup.setYear(group.year);
    return newGroup;
  }
}
