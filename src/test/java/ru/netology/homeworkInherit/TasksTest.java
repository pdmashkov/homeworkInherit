package ru.netology.homeworkInherit;

import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actualSimpleTask = simpleTask.matches("Позвонить");
        boolean actualEpic1 = epic.matches("Мол");
        boolean actualEpic2 = epic.matches("Яйц");
        boolean actualEpic3 = epic.matches("леб");
        boolean actualMeeting1 = meeting.matches("версии приложения");
        boolean actualMeeting2 = meeting.matches(" НетоБанка");

        assert actualSimpleTask;
        assert actualEpic1;
        assert actualEpic2;
        assert actualEpic3;
        assert actualMeeting1;
        assert actualMeeting2;
    }

    @Test
    public void shouldNotFindTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actualSimpleTask = simpleTask.matches("Сороксемь");
        boolean actualEpic1 = epic.matches("Степан");
        boolean actualEpic2 = epic.matches("Булава");
        boolean actualEpic3 = epic.matches("Топор");
        boolean actualMeeting1 = meeting.matches("Выкатка 4й версии приложения");
        boolean actualMeeting2 = meeting.matches("Приложение банка");

        assert !actualSimpleTask;
        assert !actualEpic1;
        assert !actualEpic2;
        assert !actualEpic3;
        assert !actualMeeting1;
        assert !actualMeeting2;
    }
}
