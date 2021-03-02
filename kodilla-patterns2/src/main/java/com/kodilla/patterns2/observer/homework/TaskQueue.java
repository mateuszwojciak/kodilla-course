package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable {
    private final String name;
    private final List<Observer> observers;
    private final List<Task> tasks;

    public TaskQueue(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTasks(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}
