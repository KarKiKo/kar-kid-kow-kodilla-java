package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList toDoList = (TaskList)context.getBean("toDoList");
        TaskList inProgressList = (TaskList)context.getBean("inProgressList");
        TaskList doneList = (TaskList)context.getBean("doneList");
        //When
        toDoList.addTask("toDo Dinner");
        toDoList.addTask("toDo Laundry");
        inProgressList.addTask("inProgress learning");
        doneList.addTask("done dishwashing");
        doneList.addTask("done vacuuming");
        //Then
        board.readLists();
    }
}
