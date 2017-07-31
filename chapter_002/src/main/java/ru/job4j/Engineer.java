/**
 * Class Engineer.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j;

/**
 * Class with Engineer person.
 */
public class Engineer extends Profession {
    /**
     * Constructor.
     * @param name - name of engineer
     * @param speciality - speciality of engineer
     */
    public Engineer(String name, String speciality) {
        super(name, speciality);
    }
    /**
     * Repair an equipment.
     *  @param profession - person with equipment to repair
     *  @return String - result of repairing
     */
    public String repairEquipment(Profession profession) {
        return String.format("%s %s ремонтирует инструменты у %s", getSpeciality(), getName(), profession.getName());
    }


}
