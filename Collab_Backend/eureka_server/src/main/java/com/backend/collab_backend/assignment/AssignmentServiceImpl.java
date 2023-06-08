package com.backend.collab_backend.assignment;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
  private static final Logger logger = LoggerFactory.getLogger(AssignmentServiceImpl.class);
  private final AssignmentRepository assignmentRepository;

  @Override
  public List<AssignmentDTO> findAllByGroup(String group) {
    List<Assignment> allAssignments = assignmentRepository.findAllByGroupId(group);
    logger.info("Found [{}] assignments active for group[{}]", allAssignments.size(), group);
    List<AssignmentDTO> returnListOfAssignments = new ArrayList<>();
    if (allAssignments.isEmpty()){
      returnListOfAssignments.add(new AssignmentDTO("Web Programming", "Lab 3", "Make a GUI", "FAF-191", "LAB", "5h", LocalDate.of(2023, 5, 19), "Ana Bejan"));
      returnListOfAssignments.add(new AssignmentDTO( "LFPC", "Project 2", "Convert a final automata into an NFA", "FAF-191", "PROJECT",  "2h", LocalDate.of(2023, 3, 15), "Darius Flocea"));
      returnListOfAssignments.add(new AssignmentDTO( "Graphic Design", "Chapter 10", "FAF-191", "READING",  "1h", "2023, 03, 13", LocalDate.of(2023, 5, 18), "Matei Corjan"));
      returnListOfAssignments.add(new AssignmentDTO( "Computation & Complexity", "Gr. Pr. 2", "FAF-191", "PROJECT",  "PROJECT","15h", LocalDate.of(2023, 3, 20), "Anatolii Gheorghiu"));
      return returnListOfAssignments;
    } else {
      for (Assignment assignment : allAssignments){
        returnListOfAssignments.add(convertAssignmentToDTO(assignment));
      }
    }
    return returnListOfAssignments;
  }

  public AssignmentDTO findAssignmentById(Long id) {
    Assignment assignment = assignmentRepository.findById(id).orElseGet(Assignment::new);

    return convertAssignmentToDTO(assignment);
  }

  public AssignmentDTO convertAssignmentToDTO(Assignment assignment){
    return new AssignmentDTO(assignment.getCourse(),
                            assignment.getTitle(),
                            assignment.getDescription(),
                            assignment.getGroupId(),
                            assignment.getType(),
                            assignment.getTime(),
                            assignment.getDueDate(),
                            assignment.getTeacherName());
  }

  @Override
  public AssignmentDTO createAssignment(AssignmentDTO assignment) {
    // Shall take the teacher from the security context
    Assignment assignment1 = new Assignment();
    assignment1.setTitle(assignment.title);
    assignment1.setDescription(assignment.description);
    assignment1.setCourse(assignment.course);
    assignment1.setGroupId(assignment.group);
    assignment1.setType(assignment.type);
    assignment1.setDueDate(assignment.dueDate);
    assignment1.setTime(assignment.time);
    assignment1.setTeacherName(assignment.teacherName);
    assignmentRepository.save(assignment1);
    return assignment;
  }

  public AssignmentDTO updateAssignment(Long id, AssignmentDTO assignment) {
    Assignment assignmentToUpdate = assignmentRepository.findById(id).orElseGet(Assignment::new);
    assignmentToUpdate.setTitle(assignment.title);
    assignmentToUpdate.setDescription(assignment.description);
    assignmentToUpdate.setCourse(assignment.course);
    assignmentToUpdate.setGroupId(assignment.group);
    assignmentToUpdate.setType(assignment.type);
    assignmentToUpdate.setDueDate(assignment.dueDate);
    assignmentToUpdate.setTime(assignment.time);
    assignmentToUpdate.setTeacherName(assignment.teacherName);
    assignmentRepository.deleteById(id);
    assignmentToUpdate.setAssignmentId(id);

    assignmentRepository.save(assignmentToUpdate);
    return assignment;
  }

  public void deleteAssignment(Long id) {
    assignmentRepository.deleteById(id);
  }


}
