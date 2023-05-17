package com.backend.collab_backend.schedule;

import java.util.List;

public interface ScheduleService {
  Schedule createSchedule(Schedule schedule);
  Schedule updateSchedule(Long scheduleId, Schedule schedule);
  void deleteSchedule(Long scheduleId);
  Schedule getScheduleById(Long scheduleId);
  List<Schedule> getAllSchedules();
  /**
   * Get the progress of an assignment for a specific student.
   *
   * @param assignmentId the ID of the assignment
   * @param studentId the ID of the student
   * @return the progress of the assignment
   */
//  double getAssignmentProgress(long assignmentId, long studentId);
}