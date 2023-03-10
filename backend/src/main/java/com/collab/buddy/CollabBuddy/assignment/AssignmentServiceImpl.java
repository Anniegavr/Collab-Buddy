package com.collab.buddy.CollabBuddy.assignment;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> findAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        Assignment assignmentToUpdate = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

        assignmentToUpdate.setName(assignment.getName());
        assignmentToUpdate.setDescription(assignment.getDescription());
        assignmentToUpdate.setDueDate(assignment.getDueDate());
//        assignmentToUpdate.setTeacher(assignment.getTeacher());

        return assignmentRepository.save(assignmentToUpdate);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
