package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        drivingTask.executeTask();
        //Then
        assertEquals(true, drivingTask.isTaskExecuted());
        assertEquals("Driving task", drivingTask.getTaskName());
    }
    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        //Then
        assertFalse(paintingTask.isTaskExecuted());
        assertEquals("Painting task", paintingTask.getTaskName());
    }
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        //Then
        assertTrue(shoppingTask.isTaskExecuted());
        assertEquals("Shopping task", shoppingTask.getTaskName());

    }
}
