package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTaskFactory() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.executeTask(TaskFactory.SHOPPING);
        //Then
        System.out.println(shopping.getTaskName());
        assertEquals("Zakup", shopping.getTaskName());
        assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    void testPaintingTaskFactory() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.executeTask(TaskFactory.PAINTING);
        //Then
        System.out.println(painting.getTaskName());
        assertEquals("Malowanie", painting.getTaskName());
        assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    void testDrivingTaskFactory() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.executeTask(TaskFactory.DRIVING);
        //Then
        System.out.println(driving.getTaskName());
        assertEquals("Przejazd", driving.getTaskName());
        assertEquals(true, driving.isTaskExecuted());
    }
}
