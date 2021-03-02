package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer {
    private final String name;
    private int numberOfTasks;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println("Mentor " + name + " otrzymał informację o wysłaniu Twojego zadania w kolejce: " + taskQueue.getName() + ".");
        numberOfTasks++;
    }
}
