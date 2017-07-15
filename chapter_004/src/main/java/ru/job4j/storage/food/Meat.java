package ru.job4j.storage.food;

import java.util.Date;

/**
 * Meat class.
 */
public class Meat extends Food {
    /**
     * Default constructor.
     * @param name - meat name.
     * @param expireDate - date of expire.
     * @param createDate - date of creation.
     * @param price - price of meat.
     * @param discount - discount of meat in percent.
     */
    public Meat(String name, Date expireDate, Date createDate, int price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
