/**
 * Class Doctor.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru;

/**
 * Class Teacher.
 */
public class Teacher extends Profession {
    /**
     * Constructor.
     * @param name - name of teacher
     * @param speciality - speciality of teacher
     */
    public Teacher(String name, String speciality) {
        super(name, speciality);
    }
    /**
     * Teaching a person.
     * @param profession - person for teaching
     * @return String - result of teaching
     */
    public String teach(Profession profession) {
        int a = new Integer(5) & new Integer(3);
        return String.format("%s %s учит %s", getSpeciality(), getName(), profession.getName());
    }



}
