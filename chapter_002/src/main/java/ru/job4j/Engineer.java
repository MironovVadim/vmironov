/**
 * Class Engineer.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j;

import java.io.File;

/**
 * Class with Engineer person.
 */
public class Engineer extends Profession {
    /**
     * Category of engineer.
     */
    private int category;
    /**
     * Constructor.
     * @param name - name of engineer
     * @param surname - surname of engineer
     * @param speciality - speciality of engineer
     * @param category - category of engineer
     */
    public Engineer(String name, String surname, String speciality, int category) {
        super(name, surname, speciality);
        this.category = Math.abs(category);
    }
    /**
     * Category getter.
     * @return int - category
     */
    public int getCategory() {
        return category;
    }
    /**
     * Making a document.
     *  @param subject - theme of document
     *  @return File - file with document
     */
    public File makeADocument(String subject) {
        File file = new File(subject);
        return file;
    }


}
