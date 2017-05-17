/**
 * Class for drawing picture.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.strategy;

/**
 * Class Paint.
 */
public class Paint {
    /**
     * Draw shape.
     * @param shape - shape for drawing
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
