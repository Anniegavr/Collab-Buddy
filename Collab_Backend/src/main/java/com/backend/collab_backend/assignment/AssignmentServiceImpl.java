//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.backend.collab_backend.assignment;

import com.backend.collab_backend.teacher.TeacherDTO;
import com.backend.collab_backend.teacher.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
  private final TeacherService teacherService;

  private final AssignmentRepository assignmentRepository;

  @Override
  public List<AssignmentDTO> findAllAssignments(List<String> groups) {
    List<Assignment> allAssignments = assignmentRepository.findAllByGroupIdIn(groups);
    List<AssignmentDTO> returnListOfAssignments = new ArrayList<>();
    if (allAssignments.isEmpty()){
      return new ArrayList<>();
    } else {
      for (Assignment assignment : allAssignments){
        returnListOfAssignments.add(convertAssignmentToDTO(assignment));
      }
    }
    return returnListOfAssignments;
  }

  @Override
  public AssignmentDTO findAssignmentById(Long id) {
    Assignment assignment = assignmentRepository.findById(id).orElseGet(Assignment::new);

    return convertAssignmentToDTO(assignment);
  }

  public AssignmentDTO convertAssignmentToDTO(Assignment assignment){
    AssignmentDTO assignmentDTO = new AssignmentDTO();
    assignmentDTO.setTitle(assignment.getTitle());
    assignmentDTO.setDescription(assignment.getDescription());

    TeacherDTO teacherName = teacherService.getTeacherByTeacherId(assignment.getTeacherId());
    assignmentDTO.setTeacherName(teacherName.getFirstName()+" "+teacherName.getLastName());
    return assignmentDTO;
  }


  @Override
  public AssignmentDTO findAssignmentById(Long id, TeacherDTO teacher) {
    Assignment assignment = assignmentRepository.findById(id)
            .orElseGet(Assignment::new);
    TeacherDTO teacherName = teacherService.getTeacherByTeacherId(assignment.getTeacherId());

    AssignmentDTO assignmentDTO = new AssignmentDTO();
    assignmentDTO.setTitle(assignment.getTitle());
    assignmentDTO.setDescription(assignment.getDescription());
    assignmentDTO.setTeacherName(teacherName.getFirstName()+" "+teacherName.getLastName());

//        if (teacher == null || !assignment.getTeacher().equals(teacher)) {
//            return assignment;
//        }
//
//        return assignment.
//                .canModify(true)
//                .canDelete(true)
//                .build();
    return assignmentDTO;
  }

  @Override
  public AssignmentDTO updateAssignment(Long id, AssignmentDTO assignment) {
    return new AssignmentDTO();
  }

  @Override
  public AssignmentDTO createAssignment(AssignmentDTO assignment) {
    // Shall take the teacher from the security context
//        TeacherDTO teacher = teacherService.getTeacherByTeacherId(assignment.getTeacherId());
//        if (teacher == null || !teacher.getCourses().contains(assignment.getDescription())) {
//            throw new RuntimeException("Teacher cannot create an assignment for this course.");
//        }

    Assignment assignment1 = new Assignment();
    assignment1.setTitle(assignment.getTitle());
    assignment1.setDescription(assignment.getDescription());

    assignmentRepository.save(assignment1);
    return assignment;
  }

  @Override
  public void updateAssignment(Long id, Assignment assignment, TeacherDTO teacher) {
    Assignment assignmentToUpdate = assignmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

//        if (!assignmentToUpdate.getTeacherId().equals(teacher.)) {
//            throw new IllegalStateException("Teacher cannot update this assignment.");
//        }

    assignmentToUpdate.setTitle(assignment.getTitle());
    assignmentToUpdate.setDescription(assignment.getDescription());
    assignmentToUpdate.setDueDate(assignment.getDueDate());

    assignmentRepository.save(assignmentToUpdate);
  }

  @Override
  public void deleteAssignment(Long id) {
    Assignment assignment = assignmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

//        if (!assignment.getTeacher().equals(teacher)) {
//            throw new RuntimeException("Teacher cannot delete this assignment.");
//        }

    assignmentRepository.deleteById(id);
  }


}
