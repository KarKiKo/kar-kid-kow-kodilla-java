package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task{
    final String taskName;
    final String color;
    final String whatToPaint;
    boolean taskExecution;

    public PaintingTask(final String taskName, final String color, final String whatToPaint){
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        taskExecution = false;
    }

    @Override
    public void executeTask(){
        taskExecution = true;
    }

    @Override
    public String getTaskName(){
        return taskName;
    }

    @Override
    public boolean isTaskExecuted(){
        return taskExecution;
    }
}
