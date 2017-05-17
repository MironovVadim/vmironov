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
    private Shape shape;

    /**
     * Constructor.
     * @param shape - shape for drawing
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Draw shape.
     */
    public void draw() {
        System.out.print(shape.pic());
    }
}
