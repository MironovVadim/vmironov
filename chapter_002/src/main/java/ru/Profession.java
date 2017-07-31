/**
 * Class Profession.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru;

/**
 * Class-parent for other classes.
 */
public class Profession {
    /**
     * name of person.
     */
    private String name;
    /**
     * speciality of person.
     */
    private String speciality;
    /**
     * Constructor.
     * @param name - name of person
     * @param speciality - speciality of person
     */
    public Profession(String name, String speciality) {
        this.name = name;
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
     * Speciality getter.
     * @return String - speciality of person
     */
    public String getSpeciality() {
        return speciality;
    }
}
