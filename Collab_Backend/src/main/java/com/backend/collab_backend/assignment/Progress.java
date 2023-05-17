package com.backend.collab_backend.assignment;

public class Progress {
  public Long taskId;

  public Progress(String taskName, int progress) {
    this.taskName = taskName;
    this.progress = progress;
  }

  public String taskName;
  public int progress;
}
