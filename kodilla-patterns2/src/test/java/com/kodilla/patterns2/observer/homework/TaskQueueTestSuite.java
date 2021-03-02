package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskQueueTestSuite {

    @Test
    public void testTaskQueueNotifications() {
        //Given
        Task taskOne = new Task("New task 1");
        Task taskTwo = new Task("New task 2");
        Task taskThree = new Task("New task 3");
        Task taskFour = new Task("New task 4");
        Task taskFive = new Task("New task 5");
        Task taskSix = new Task("New task 6");

        Mentor mentorOne = new Mentor("Jan");
        Mentor mentorTwo = new Mentor("Andrzej");

        TaskQueue studentOneTasks = new TaskQueue("Kolejka studenta 1");
        TaskQueue studentTwoTasks = new TaskQueue("Kolejka studenta 2");

        studentOneTasks.registerObserver(mentorOne);
        studentTwoTasks.registerObserver(mentorTwo);

        //When
        studentOneTasks.addTasks(taskOne);
        studentOneTasks.addTasks(taskTwo);
        studentOneTasks.addTasks(taskThree);
        studentTwoTasks.addTasks(taskFour);
        studentTwoTasks.addTasks(taskFive);
        studentTwoTasks.addTasks(taskSix);

        //Then
        assertEquals(3, mentorOne.getNumberOfTasks());
        assertEquals(3, mentorTwo.getNumberOfTasks());

    }
}
