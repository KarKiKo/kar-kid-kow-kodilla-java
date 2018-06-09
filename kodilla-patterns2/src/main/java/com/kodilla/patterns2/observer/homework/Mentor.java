package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int counter;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println(mentorName + ": Your mentee " + taskQueue.getMenteeName() + " just has sent new task to be reviewed.\n" +
        "In this mentee queue there is/are " + taskQueue.getTasks().size() + " task/tasks awaiting for you\n");
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public String getMentorName() {
        return mentorName;
    }
}
