package ru.job4j;

/**
 * Created by ПК on 09.05.2017.
 */
public class Teacher extends Profession {
    /**
     * Constructor.
     * @param name - name of teacher
     * @param surname - surname of teacher
     * @param speciality - speciality of teacher
     */
    public Teacher(String name, String surname, String speciality) {
        super(name, surname, speciality);
    }
    /**
     * Checking home work.
     * @param pupils - massif of pupils
     * @return String - result of checking
     */
    public String checkHomeWork(String[] pupils) {
        StringBuilder sb = new StringBuilder(String.format("%s %s проверил(а) домашние задания у следующих учеников: ", getName(), getSurname()));
        for (String pupil : pupils) {
            sb.append(pupil + ", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
    /**
     * Conducting a lesson.
     * @param pupils - massif of pupils
     * @return String - result of conducting a lesson
     */
    public String conductALesson(String[] pupils) {
        StringBuilder sb = new StringBuilder(String.format("%s %s провел(а) занятия у следующих учеников: ", getName(), getSurname()));
        for (String pupil : pupils) {
            sb.append(pupil + ", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

}
