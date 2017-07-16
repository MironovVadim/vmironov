package ru.job4j.storage.food;

import java.util.Date;

/**
 * Fruit class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Fruit extends Food {

    /**
     * Default constructor.
     * @param name - name of fruit.
     * @param expireDate - date of expire.
     * @param createDate - date of creation.
     * @param price - price of fruit.
     * @param discount - discount of fruit in percent.
     * @param canReproduct - is food can reproduct after expire.
     * @param isColdStorage - is food must be stored in fridge.
     */
    public Fruit(String name, Date expireDate, Date createDate, int price, int discount, boolean canReproduct, boolean isColdStorage) {
        super(name, expireDate, createDate, price, discount, canReproduct, isColdStorage);
    }
}
