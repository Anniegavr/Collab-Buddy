//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//

package com.backend.collab_backend.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

  private final ScheduleService scheduleService;


  @PostMapping
  public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
    Schedule createdSchedule = scheduleService.createSchedule(schedule);
    return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
  }

  @PutMapping("/{scheduleId}")
  public ResponseEntity<Schedule> updateSchedule(@PathVariable Long scheduleId, @RequestBody Schedule schedule) {
    Schedule updatedSchedule = scheduleService.updateSchedule(scheduleId, schedule);
    return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
  }

  @DeleteMapping("/{scheduleId}")
  public ResponseEntity<?> deleteSchedule(@PathVariable Long scheduleId) {
    scheduleService.deleteSchedule(scheduleId);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{scheduleId}")
  public ResponseEntity<Schedule> getScheduleById(@PathVariable Long scheduleId) {
    Schedule schedule = scheduleService.getScheduleById(scheduleId);
    return new ResponseEntity<>(schedule, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Schedule>> getAllSchedules() {
    List<Schedule> schedules = scheduleService.getAllSchedules();
    return new ResponseEntity<>(schedules, HttpStatus.OK);
  }


  @GetMapping("/progress/{assignmentId}/{studentId}")
  public ResponseEntity<Double> getAssignmentProgress(@PathVariable long assignmentId, @PathVariable long studentId) {
    double progress = 0.75;//scheduleService.getAssignmentProgress(assignmentId, studentId);
    return ResponseEntity.ok(progress);
  }
}
