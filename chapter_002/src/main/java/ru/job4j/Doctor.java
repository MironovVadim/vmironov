/**
 * Class Doctor.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j;

/**
 * Class with Doctor person.
 */
public class Doctor extends Profession {
    /**
     * Constructor.
     *
     * @param name - name of doctor
     * @param speciality - speciality of doctor
     */
    public Doctor(String name, String speciality) {
        super(name, speciality);
    }
    /**
     * Healing a profession.
     * @param profession - some person for healing
     * @return String - return result of healing
     */
    public String heal(Profession profession) {
        return String.format("%s %s лечит %s", getSpeciality(), getName(), profession.getName());
    }
}


