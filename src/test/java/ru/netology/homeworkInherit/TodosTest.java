package ru.netology.homeworkInherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
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

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTask() {
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

        Task[] expectedSimpleTask = {simpleTask};
        Task[] actualSimpleTask = todos.search("Позвонить");

        Task[] expectedEpic1 = {epic};
        Task[] actualEpic1 = todos.search("Мол");

        Task[] expectedEpic2 = {epic};
        Task[] actualEpic2 = todos.search("Яйц");

        Task[] expectedEpic3 = {epic};
        Task[] actualEpic3 = todos.search("леб");

        Task[] expectedMeeting1 = {meeting};
        Task[] actualMeeting1 = todos.search("версии приложения");

        Task[] expectedMeeting2 = {meeting};
        Task[] actualMeeting2 = todos.search(" НетоБанка");

        Assertions.assertArrayEquals(expectedSimpleTask, actualSimpleTask);
        Assertions.assertArrayEquals(expectedEpic1, actualEpic1);
        Assertions.assertArrayEquals(expectedEpic2, actualEpic2);
        Assertions.assertArrayEquals(expectedEpic3, actualEpic3);
        Assertions.assertArrayEquals(expectedMeeting1, actualMeeting1);
        Assertions.assertArrayEquals(expectedMeeting2, actualMeeting2);
    }

    @Test
    public void shouldNotSearchTask() {
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

        Task[] expected = {};

        Task[] actualSimpleTask = todos.search("Коллега");
        Task[] actualEpic1 = todos.search("Шар");
        Task[] actualEpic2 = todos.search("Часы");
        Task[] actualEpic3 = todos.search("Книга");
        Task[] actualMeeting1 = todos.search(" приложения для телефона");
        Task[] actualMeeting2 = todos.search(" Бутылка");

        Assertions.assertArrayEquals(expected, actualSimpleTask);
        Assertions.assertArrayEquals(expected, actualEpic1);
        Assertions.assertArrayEquals(expected, actualEpic2);
        Assertions.assertArrayEquals(expected, actualEpic3);
        Assertions.assertArrayEquals(expected, actualMeeting1);
        Assertions.assertArrayEquals(expected, actualMeeting2);
    }
}
