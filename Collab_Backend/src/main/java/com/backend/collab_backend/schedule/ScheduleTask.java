package com.backend.collab_backend.schedule;

public class ScheduleTask {
  public ScheduleTask(String taskName, int hours) {
    this.taskName = taskName;
    this.hours = hours;
  }

  public Long id;
  public String taskName;
  public int hours;
}
