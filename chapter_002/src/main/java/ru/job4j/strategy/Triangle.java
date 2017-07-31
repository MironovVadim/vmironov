/**
 * Class that return picture.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.strategy;



/**
 * Class Triangle.
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("00000" + System.lineSeparator()).append(" 000 " + System.lineSeparator()).append("  0  ");
        return sb.toString();
    }
}
