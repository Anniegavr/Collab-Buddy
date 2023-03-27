package com.collab.buddy.assignment;

import com.collab.buddy.teacher.TeacherDTO;
import com.collab.buddy.teacher.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    private final TeacherService teacherService;

    private final AssignmentRepository assignmentRepository;

    @Override
    public List<AssignmentDTO> findAllAssignments() {
        return new ArrayList<>(); //TODO make this methos return a list of DTOs
                //assignmentRepository.findAll();
    }

    @Override
    public AssignmentDTO findAssignmentById(Long id) {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        Assignment assignment = assignmentRepository.findById(id).orElseGet(Assignment::new);
        AssignmentDTO assignmentDTO1 = convertAssignmentToDTO(assignment);

        return assignmentDTO1;
    }

    public AssignmentDTO convertAssignmentToDTO(Assignment assignment){
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setName(assignment.getName());
        assignmentDTO.setDescription(assignment.getDescription());

        TeacherDTO teacherName = teacherService.getTeacherByTeacherId(assignment.getTeacherId());
        assignmentDTO.setTeacherName(teacherName.getFirstName()+" "+teacherName.getLastName());
        assignmentDTO.setDueDate(assignment.getDueDate());
        return assignmentDTO;
    }


    @Override
    public AssignmentDTO findAssignmentById(Long id, TeacherDTO teacher) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseGet(Assignment::new);
        TeacherDTO teacherName = teacherService.getTeacherByTeacherId(assignment.getTeacherId());

        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setName(assignment.getName());
        assignmentDTO.setDescription(assignment.getDescription());
        assignmentDTO.setTeacherName(teacherName.getFirstName()+" "+teacherName.getLastName());
        assignmentDTO.setDueDate(assignment.getDueDate());
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
        //TODO implement
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
        assignment1.setName(assignment.getName());
        assignment1.setDescription(assignment.getDescription());
        assignment1.setDueDate(assignment.getDueDate());

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

        assignmentToUpdate.setName(assignment.getName());
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

