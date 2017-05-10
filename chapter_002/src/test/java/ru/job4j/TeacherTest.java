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
    public void whenTeachSergeiThenTeachingHim() {
        Teacher teacher = new Teacher("Владимир", "Историк");
        Profession doctor = new Doctor("Сергей", "Хирург");
        String result = teacher.teach(doctor);
        String expected = String.format("%s %s учит %s", teacher.getSpeciality(), teacher.getName(), doctor.getName());
        assertThat(result, is(expected));

    }
}
