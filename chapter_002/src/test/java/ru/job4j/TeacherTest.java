package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Teacher.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TeacherTest {
    /**
     * Test method.
     */
    @Test
    public void whenPutTwoPupilsThenCheckTheirHomeWork() {
        Teacher teacher = new Teacher("Сергей", "Булыжников", "Историк");
        String[] pupils = {"Андрей Некто", "Сергей Некто"};
        StringBuilder sb = new StringBuilder(String.format("%s %s проверил(а) домашние задания у следующих учеников: %s, %s", teacher.getName(), teacher.getSurname(), pupils[0], pupils[1]));
        String result = sb.toString();
        String expected = teacher.checkHomeWork(pupils);
        assertThat(result, is(expected));
    }
    /**
     * Test method.
     */
    @Test
    public void whenPutTwoPupilsThenConductALesson() {
        Teacher teacher = new Teacher("Сергей", "Булыжников", "Историк");
        String[] pupils = {"Андрей Некто", "Сергей Некто"};
        StringBuilder sb = new StringBuilder(String.format("%s %s провел(а) занятия у следующих учеников: %s, %s", teacher.getName(), teacher.getSurname(), pupils[0], pupils[1]));
        String result = sb.toString();
        String expected = teacher.conductALesson(pupils);
        assertThat(result, is(expected));
    }
}
