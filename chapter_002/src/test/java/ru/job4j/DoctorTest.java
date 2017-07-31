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
    public void whenHealVladClientThenHeHealed() {
        Doctor doctor = new Doctor("Сергей", "Хирург");
        Profession engineer = new Engineer("Влад", "Судостроитель");
        String result = doctor.heal(engineer);
        String expected = String.format("%s %s лечит %s", doctor.getSpeciality(), doctor.getName(), engineer.getName());
        assertThat(result, is(expected));
    }
}
