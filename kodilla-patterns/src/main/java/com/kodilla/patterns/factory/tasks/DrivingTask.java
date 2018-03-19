package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task{

    final String taskName;
    final String where;
    final String using;
    boolean taskExecution;

    public DrivingTask(final String taskName, final String where, final String using){
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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
