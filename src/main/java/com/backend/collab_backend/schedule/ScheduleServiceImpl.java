package com.backend.collab_backend.schedule;

import com.backend.collab_backend.assignment.Assignment;
import com.backend.collab_backend.student.Student;
import com.backend.collab_backend.student.progress.ProgressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
  private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
  private final ScheduleRepository scheduleRepository;

  // Method to calculate the remaining unallocated time for a student's homework
//  public int calculateUnallocatedTimeForHomework(Student student, LocalDate startDate, LocalDate endDate) {
//    int totalHomeworkTime = calculateTotalHomeworkTime(startDate, endDate);
//    int totalAllocatedTime = student.getAllocatedHomeworkTime(startDate, endDate);
//    return totalHomeworkTime - totalAllocatedTime;
//  }
//
//  // Method to calculate the total time required for a given assignment
//  public int calculateTotalAssignmentTime(Assignment assignment) {
//    return assignment.getTime();
//  }

  // Method to split the time required for an assignment over a range of dates, ensuring that it fits within a student's homework time
  public Map<LocalDate, Integer> splitAssignmentTimeOverDates(int totalAssignmentTime, LocalDate startDate, LocalDate endDate, int unallocatedHomeworkTime) {
    Map<LocalDate, Integer> assignmentSchedule = new HashMap<>();
    int totalDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
    int totalAssignableTime = unallocatedHomeworkTime < 0 ? 0 : unallocatedHomeworkTime;
    int timePerDay = totalAssignableTime / totalDays;
    int remainingTime = totalAssignableTime % totalDays;

    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
      int assignableTime = timePerDay + (remainingTime-- > 0 ? 1 : 0);
      assignableTime = Math.min(assignableTime, totalAssignmentTime);
      totalAssignmentTime -= assignableTime;
      assignmentSchedule.put(date, assignableTime);
    }
    return assignmentSchedule;
  }

  // Method to validate an assignment's due date based on a student's homework schedule
//  public boolean validateDueDate(Assignment assignment, Student student, LocalDate startDate) {
//    LocalDate dueDate = assignment.getDueDate();
//    int totalAssignmentTime = calculateTotalAssignmentTime(assignment);
//    int unallocatedHomeworkTime = calculateUnallocatedTimeForHomework(student, startDate, dueDate.minusDays(1));
//    Map<LocalDate, Integer> assignmentSchedule = splitAssignmentTimeOverDates(totalAssignmentTime, startDate, dueDate.minusDays(1), unallocatedHomeworkTime);
//    return assignmentSchedule.values().stream().allMatch(time -> time > 0);
//  }

  // Method to adjust an assignment's due date to fit within a student's homework schedule
//  public LocalDate adjustDueDate(Assignment assignment, Student student, LocalDate startDate) {
//    LocalDate dueDate = assignment.getDueDate();
//    int totalAssignmentTime = calculateTotalAssignmentTime(assignment);
//    int unallocatedHomeworkTime = calculateUnallocatedTimeForHomework(student, startDate, dueDate.minusDays(1));
//    Map<LocalDate, Integer> assignmentSchedule = splitAssignmentTimeOverDates(totalAssignmentTime, startDate, dueDate.minusDays(1), unallocatedHomeworkTime);
//    while (assignmentSchedule.values().stream().anyMatch(time -> time <= 0)) {
//      dueDate = dueDate.plusDays(1);
//      unallocatedHomeworkTime = calculateUnallocatedTimeForHomework(student, startDate, dueDate.minusDays(1));
//      assignmentSchedule = splitAssignmentTimeOverDates(totalAssignmentTime, startDate, dueDate.minusDays(1), unallocatedHomeworkTime);
//    }
//    return dueDate;
//  }

  @Override
  public Schedule createSchedule(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }

  @Override
  public Schedule updateSchedule(Long scheduleId, Schedule schedule) {
    Schedule existingSchedule = getScheduleById(scheduleId);
//    existingSchedule.setTitle(schedule.getTitle());
//    existingSchedule.setDescription(schedule.getDescription());
//    existingSchedule.setEstimatedTime(schedule.getEstimatedTime());
//    existingSchedule.setDueDate(schedule.getDueDate());
    return scheduleRepository.save(existingSchedule);
  }

  @Override
  public void deleteSchedule(Long scheduleId) {
    scheduleRepository.deleteById(scheduleId);
  }

  @Override
  public Schedule getScheduleById(Long scheduleId) {
    return scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id " + scheduleId));
  }

  @Override
  public List<Schedule> getAllSchedules() {
    return scheduleRepository.findAll();
  }


//  @Override
//  public double getAssignmentProgress(long assignmentId, long studentId) {
//    double totalWorkTime = scheduleRepository.getTotalWorkTimeForAssignmentAndStudent(assignmentId, studentId);
//    double estimatedWorkTime = scheduleRepository.getEstimatedWorkTimeForAssignment(assignmentId);
//    return totalWorkTime / estimatedWorkTime;
//  }
}
