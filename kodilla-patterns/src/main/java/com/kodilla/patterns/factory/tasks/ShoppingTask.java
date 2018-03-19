package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {

    final String taskName;
    final String whatToBuy;
    final double quantity;
    boolean taskExecution;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity){
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
