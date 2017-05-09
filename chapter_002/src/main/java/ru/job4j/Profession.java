/**
 * Class Profession.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j;

/**
 * Class-parent for other classes.
 */
public class Profession {
    /**
     * name of person.
     */
    private String name;
    /**
     * surname of person.
     */
    private String surname;
    /**
     * speciality of person.
     */
    private String speciality;
    /**
     * Constructor.
     * @param name - name of person
     * @param surname - surname of person
     * @param speciality - speciality of person
     */
    public Profession(String name, String surname, String speciality) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
    }
    /**
     * Name getter.
     * @return String - name of person
     */
    public String getName() {
        return name;
    }
    /**
     * Surname getter.
     * @return String - surname of person
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Speciality getter.
     * @return String - speciality of person
     */
    public String getSpeciality() {
        return speciality;
    }
}
