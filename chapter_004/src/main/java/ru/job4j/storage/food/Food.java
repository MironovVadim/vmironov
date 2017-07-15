package ru.job4j.storage.food;

import java.util.Date;

/**
 * Basic class of food.
 */
public class Food {
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
     * Default constructor.
     * @param name - name of food.
     * @param createDate - date of expire.
     * @param expireDate - date of creation.
     * @param price - price of food.
     * @param discount - discount of food in percent.
     */
    public Food(String name, Date createDate, Date expireDate, int price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
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
            price = price * (100 - discount) / 100;
            isDiscounted = true;
        }
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
        if (name != null ? !name.equals(food.name) : food.name != null) {
            return false;
        }
        if (createDate != null ? !createDate.equals(food.createDate) : food.createDate != null) {
            return false;
        }
        return expireDate != null ? expireDate.equals(food.expireDate) : food.expireDate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + discount;
        result = 31 * result + (isDiscounted ? 1 : 0);
        return result;
    }
}
