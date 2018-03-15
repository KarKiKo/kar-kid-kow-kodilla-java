package com.kodilla.spring.portfolio;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void readLists() {
        System.out.println("ToDoList");
        toDoList.readList();
        System.out.println("\nInProgressList");
        inProgressList.readList();
        System.out.println("\nDoneList");
        doneList.readList();
    }

}
