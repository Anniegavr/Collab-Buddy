package com.backend.collab_backend.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  Optional<Schedule> findScheduleByDate(LocalDate date);
  Optional<Schedule> findScheduleByIdAndAssignmentId(Long schId, Long assignId);
  Optional<Schedule> findScheduleByGroupId(String id);
  Optional<Schedule> findScheduleByGroupIdAndDate(String grId, LocalDate date);

}
