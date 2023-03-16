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
    public Assignment findAssignmentById(Long id, Teacher teacher) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

        if (teacher == null || !assignment.getTeacher().equals(teacher)) {
            return assignment;
        }

        return assignment.toBuilder()
                .canModify(true)
                .canDelete(true)
                .build();
    }

    @Override
    public Assignment createAssignment(Assignment assignment, Teacher teacher) {
        if (teacher == null || !teacher.getCourses().contains(assignment.getCourse())) {
            throw new RuntimeException("Teacher cannot create an assignment for this course.");
        }

        assignment.setTeacher(teacher);
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment, Teacher teacher) {
        Assignment assignmentToUpdate = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

        if (!assignmentToUpdate.getTeacher().equals(teacher)) {
            throw new IllegalStateException("Teacher cannot update this assignment.");
        }

        assignmentToUpdate.setName(assignment.getName());
        assignmentToUpdate.setDescription(assignment.getDescription());
        assignmentToUpdate.setDueDate(assignment.getDueDate());

        return assignmentRepository.save(assignmentToUpdate);
    }

    @Override
    public void deleteAssignment(Long id, Teacher teacher) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id : " + id));

        if (!assignment.getTeacher().equals(teacher)) {
            throw new RuntimeException("Teacher cannot delete this assignment.");
        }

        assignmentRepository.deleteById(id);
    }
}

