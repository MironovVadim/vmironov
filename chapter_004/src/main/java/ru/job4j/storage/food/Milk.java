package ru.job4j.storage.food;

import java.util.Date;

/**
 * Milk class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Milk extends Food {
    /**
     * Default constructor.
     * @param name - milk name.
     * @param expireDate - date of expire.
     * @param createDate - date of creation.
     * @param price - price of milk.
     * @param discount - discount of milk in percent.
     * @param canReproduct - is food can reproduct after expire.
     * @param isColdStorage - is food must be stored in fridge.
     */
    public Milk(String name, Date expireDate, Date createDate, int price, int discount, boolean canReproduct, boolean isColdStorage) {
        super(name, expireDate, createDate, price, discount, canReproduct, isColdStorage);
    }
}
