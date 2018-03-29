package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList1 = new TaskList("ToDoList", "MyTasksToDo");
        //When
        taskListDao.save(taskList1);
        List<TaskList> readTaskList = taskListDao.findByListName("ToDoList");
        //Then
        Assert.assertEquals(taskList1.getListName(),readTaskList.get(0).getListName());
        //Clean-up
        taskListDao.delete(readTaskList.get(0).getId());
    }
}
