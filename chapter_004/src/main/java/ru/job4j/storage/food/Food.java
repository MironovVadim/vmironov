package ru.job4j.storage.food;

import java.util.Date;

/**
 * Basic class of food.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class Food {
    /**
     * Name of food.
     */
    private String name;
    /**
     * Date of creation.
     */
    private Date createDate;
    /**
     * Date of expire.
     */
    private Date expireDate;
    /**
     * Price of food.
     */
    private int price;
    /**
     * Discount used when current date near date of expire.
     */
    private int discount;
    /**
     * Is food discounted.
     */
    private boolean isDiscounted = false;
    /**
     * Is food reproducted.
     */
    private boolean canReproduct;
    /**
     * Is food must be stored in fridge.
     */
    private boolean isColdStorage = true;

    /**
     * Default constructor.
     * @param name - name of food.
     * @param createDate - date of expire.
     * @param expireDate - date of creation.
     * @param price - price of food.
     * @param discount - discount of food in percent.
     * @param canReproduct - is food can reproduct after expire.
     * @param isColdStorage - is food must be stored in fridge.
     */
    public Food(String name, Date createDate, Date expireDate, int price, int discount, boolean canReproduct, boolean isColdStorage) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
        this.canReproduct = canReproduct;
        this.isColdStorage = isColdStorage;
    }

    /**
     * Name getter.
     * @return name of food.
     */
    public String getName() {
        return name;
    }

    /**
     * Date of expire getter.
     * @return expire date.
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * Date of creation getter.
     * @return date of creation.
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Price getter.
     * @return price of food.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Discount getter.
     * @return discount of food.
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Method check is food discounted.
     * @return is food discounted.
     */
    public boolean isDiscounted() {
        return isDiscounted;
    }

    /**
     * Method set new price with discount.
     */
    public void considerDiscount() {
        if (!isDiscounted) {
            price *= (100 - discount) / 100;
            isDiscounted = true;
        }
    }

    /**
     * Method return is food can reproduce.
     * @return boolean - is food can reproduce.
     */
    public boolean isCanReproduct() {
        return canReproduct;
    }

    /**
     * Method return is food must be stored is fridge.
     * @return boolean - is food must be stored is fridge.
     */
    public boolean isColdStorage() {
        return isColdStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Food food = (Food) o;

        if (price != food.price) {
            return false;
        }
        if (discount != food.discount) {
            return false;
        }
        if (isDiscounted != food.isDiscounted) {
            return false;
        }
        if (canReproduct != food.canReproduct) {
            return false;
        }
        if (isColdStorage != food.isColdStorage) {
            return false;
        }
        if (!name.equals(food.name)) {
            return false;
        }
        if (!createDate.equals(food.createDate)) {
            return false;
        }
        return expireDate.equals(food.expireDate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + createDate.hashCode();
        result = 31 * result + expireDate.hashCode();
        result = 31 * result + price;
        result = 31 * result + discount;
        result = 31 * result + (isDiscounted ? 1 : 0);
        result = 31 * result + (canReproduct ? 1 : 0);
        result = 31 * result + (isColdStorage ? 1 : 0);
        return result;
    }
}
