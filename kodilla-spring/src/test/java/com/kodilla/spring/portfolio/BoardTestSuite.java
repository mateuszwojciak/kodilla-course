package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testBoardSuite() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        boolean showToDoList = context.containsBean("ToDoList");
        boolean showInProgressList = context.containsBean("InProgressList");
        boolean showDoneList = context.containsBean("DoneList");
        //Then
        System.out.println("Czy to-do lista istnieje: = " + showToDoList);
        System.out.println("Czy lista in progress istnieje: = " + showInProgressList);
        System.out.println("Czy lista done istnieje: = " + showDoneList);
    }

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        Board board = context.getBean(Board.class);

        List<String> toDoList = board.getToDoList().getTasks();
        toDoList.add("ToDoList");

        List<String> doneList = board.getDoneList().getTasks();
        doneList.add("DoneList");

        List<String> inProgressList = board.getInProgressList().getTasks();
        inProgressList.add("InProgressList");

        //Then
        Assertions.assertEquals("ToDoList", toDoList.get(0));
        Assertions.assertEquals("DoneList", doneList.get(0));
        Assertions.assertEquals("InProgressList", inProgressList.get(0));
    }
}
