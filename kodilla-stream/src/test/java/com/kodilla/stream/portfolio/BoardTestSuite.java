package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {

    public static int simpleDaysBetween(final LocalDate start, final LocalDate end) {
        return (int) ChronoUnit.DAYS.between(start, end);
    }

    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();
        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        double numberOfTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .count();
        double sumOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(s -> simpleDaysBetween(s.getCreated(), LocalDate.now()))
                .reduce(0, (sum, current) -> sum + current);

        double averageTaskInDays = sumOfDays / numberOfTasks;
/*        double sumOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .map(TaskList::getTasks)//null w tym przypadku bedzie obsluzony
                .flatMap(Collection::stream)//flat map sie nie wywola ale nie powstanie nullpointerexception (sprawdzic co bedzie przy 0)
                .map(s -> simpleDaysBetween(s.getCreated(), LocalDate.now()))
                .reduce(0, (sum, current) -> sum + current);*/
        //Then
        Assert.assertEquals(10.0, averageTaskInDays, 0);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask2() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));

        List<Integer> durationOfInProgressTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(t -> t.getTasks().stream())
                .map(s -> simpleDaysBetween(s.getCreated(), LocalDate.now()))
                .collect(toList());

        Double average = IntStream.range(0, durationOfInProgressTasks.size())
                .map(n -> durationOfInProgressTasks.get(n))
                .average()
                .getAsDouble();
        /*        OptionalDouble average = durationOfInProgressTasks.stream()
                .mapToInt(i -> i)
                .average();
        //Then
        Assert.assertTrue(average.isPresent());
        Assert.assertEquals(10.0, average.getAsDouble(), 0);*/


        //Then
        Assert.assertEquals(10.0, average, 0);
    }
}
/*
    public static int simpleDaysBetween(final LocalDate start) {
        return (int) ChronoUnit.DAYS.between(start, LocalDate.now());
    }

    double sumOfDays = project.getTaskLists().stream()
            .filter(inProgressTasks::contains)
            .map(TaskList::getTasks)
            .flatMap(Collection::stream)
            .map(Task::getCreated)
            .map(BoardTestSuite::simpleDaysBetween)
            .reduce(0, (sum, current) -> sum + current);*/
