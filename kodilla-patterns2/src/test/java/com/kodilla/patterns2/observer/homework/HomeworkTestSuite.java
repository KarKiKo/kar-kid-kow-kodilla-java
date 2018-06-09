package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor mentor1 = new Mentor("Mentor1");
        Mentor mentor2 = new Mentor("Mentor2");
        TaskQueue mentee1 = new TaskQueue("Mentee1");
        TaskQueue mentee2 = new TaskQueue("Mentee2");
        TaskQueue mentee3 = new TaskQueue("Mentee3");
        TaskQueue mentee4 = new TaskQueue("Mentee4");
        mentee1.registerObserver(mentor1);
        mentee2.registerObserver(mentor1);
        mentee3.registerObserver(mentor2);
        mentee4.registerObserver(mentor2);
        //When
        mentee1.addTask("Task1");
        mentee1.addTask("Task2");
        mentee1.addTask("Task3");
        mentee2.addTask("Task1");
        mentee2.addTask("Task2");
        mentee3.addTask("Task1");
        mentee4.addTask("Task1");
        mentee4.addTask("Task2");
        //Then
        assertEquals(5, mentor1.getCounter());
        assertEquals(3, mentor2.getCounter());
    }
}
