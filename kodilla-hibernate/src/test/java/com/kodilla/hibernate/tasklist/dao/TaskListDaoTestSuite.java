package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    private static final String DESCRIPTION = "Test: new point in TaskList";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("First", DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> readTask = taskListDao.findByListName("First");

        //Then
       assertEquals(1, readTask.size());

        //CleanUp
        int id = readTask.get(0).getId();
        taskListDao.deleteById(id);
    }
}
