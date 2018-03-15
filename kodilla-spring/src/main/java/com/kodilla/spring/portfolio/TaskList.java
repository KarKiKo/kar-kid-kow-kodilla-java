package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    public List<String> tasks;
    String listName;

    public TaskList(String listName) {
        tasks = new ArrayList<>();
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void readList(){
        for (String task: tasks) {
            System.out.println(task);
        }
    }
}
