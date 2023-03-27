package com.collab.buddy.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping
    public List<AssignmentDTO> findAllAssignments() {
        return assignmentService.findAllAssignments();
    }

    @GetMapping("/{id}")
    public AssignmentDTO findAssignmentById(@PathVariable Long id) {
        return assignmentService.findAssignmentById(id);
    }

    @PostMapping
    public void createAssignment(@RequestBody AssignmentDTO assignment) {
        assignmentService.createAssignment(assignment);
    }

    @PutMapping("/{id}")
    public AssignmentDTO updateAssignment(@PathVariable Long id, @RequestBody AssignmentDTO assignment) {
        return assignmentService.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
    }
}
