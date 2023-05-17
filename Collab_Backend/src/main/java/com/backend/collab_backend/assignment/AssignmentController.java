//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.backend.collab_backend.assignment;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {
  private final AssignmentService assignmentService;
//  private final AssignmentLogService assignmentLogService;
  private static final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

  @GetMapping("/all")
  public ResponseEntity<List<AssignmentDTO>> findAllAssignments(@RequestBody List<String> groups) {
    List<AssignmentDTO> returnList = assignmentService.findAllAssignments(groups);
    logger.info("Assignments that pertain to the groups [{}] are [{}]", groups, returnList.listIterator());
    return ResponseEntity.ok(returnList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AssignmentDTO> findAssignmentById(@PathVariable Long id) {
    AssignmentDTO found = assignmentService.findAssignmentById(id);
    logger.info("Found assignment [{}] for assignment_id[{}]", found, id);
    return ResponseEntity.ok(found);
  }

  @PostMapping("/new")
  public ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentDTO assignment) {
    assignmentService.createAssignment(assignment);
    return ResponseEntity.ok(assignment);
  }

  @PutMapping("/{id}")
  public AssignmentDTO updateAssignment(@PathVariable Long id, @RequestBody AssignmentDTO assignment) {
    return assignmentService.updateAssignment(id, assignment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
    assignmentService.deleteAssignment(id);
    logger.info("Deleted assignment with id[{}]", id);
    return ResponseEntity.ok("Deleted assignment with id "+id);
  }
}
