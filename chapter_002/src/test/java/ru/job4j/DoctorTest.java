package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Doctor.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class DoctorTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddnewClientThenTrue() {
        Doctor doctor = new Doctor("Сергей", "Булыжников", "Хирург");
        boolean result = true;
        boolean expected = doctor.addNewClient("Какой то пациент");
        assertThat(result, is(expected));
    }
    /**
     * Test method.
     */
    @Test
    public void whenServeNextClientThenSuccessString() {
        Doctor doctor = new Doctor("Сергей", "Булыжников", "Хирург");
        String client = "Андрей Некто";
        doctor.addNewClient(client);
        String result = String.format("Доктор %s %s вылечил пациента %s", doctor.getName(), doctor.getSurname(), client);
        String expected = doctor.serveNextClient();
        assertThat(result, is(expected));
    }
    /**
     * Test method.
     */
    @Test
    public void whenServeNextClientThenGoHomeString() {
        Doctor doctor = new Doctor("Сергей", "Булыжников", "Хирург");
        String result = "Все излечены, пора идти домой.";
        String expected = doctor.serveNextClient();
        assertThat(result, is(expected));
    }
}
