package ru;

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
public class EngineerTest {
    /**
     * Test method.
     */
    @Test
    public void whenRepairSomeThingsThenStringWithGoodResult() {
        Engineer engineer = new Engineer("Сергей", "Электрик");
        Profession doctor = new Doctor("Стас", "Дантист");
        String result = engineer.repairEquipment(doctor);
        String expected = String.format("%s %s ремонтирует инструменты у %s", engineer.getSpeciality(), engineer.getName(), doctor.getName());
        assertThat(result, is(expected));
    }
}
