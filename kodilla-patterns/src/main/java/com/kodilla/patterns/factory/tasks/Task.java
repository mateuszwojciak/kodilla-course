package com.kodilla.patterns.factory.tasks;

public interface Task {
    String getTaskName();
    boolean executeTask();
    boolean isTaskExecuted();
}
