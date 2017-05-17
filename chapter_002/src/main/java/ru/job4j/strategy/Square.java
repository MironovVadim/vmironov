package ru.job4j.strategy;
/**
 * Class that return picture.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

/**
 * Class Square.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("0000" + System.lineSeparator()).append("0  0" + System.lineSeparator()).
                append("0  0" + System.lineSeparator()).append("0  0" + System.lineSeparator()).append("0000");
        return sb.toString();
    }
}
