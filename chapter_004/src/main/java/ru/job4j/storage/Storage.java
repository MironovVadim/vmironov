package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.List;

/**
 * Interface for ru.job4j.storage food.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Storage {
    /**
     * Method pull out list of food that matches conditions for current storage.
     * @param foodList - list with all kind of food.
     * @return list of matched food for current ru.job4j.storage.
     */
    List<Food> getFoodForStorage(List<Food> foodList);

    /**
     * Storage food getter.
     * @return ru.job4j.storage food.
     */
    List<Food> getFoodFromStorage();

    /**
     * FoodList setter.
     * @param foodList - new list with food.
     */
    void setFood(List<Food> foodList);

    /**
     * Method adds more food in food ru.job4j.storage.
     * @param foodList - food for adding in food ru.job4j.storage.
     */
    void addFood(List<Food> foodList);

    /**
     * Method calculate left time of shelf time in percent.
     * @param food - specified food.
     * @return percent of left time.
     */
    default int leftTime(Food food) {
        long currentTime = System.currentTimeMillis();
        double difference1 = currentTime - food.getCreateDate().getTime();
        double difference2 = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        int leftTime = (int) (difference1 / difference2 * 100);
        return leftTime;
    }
}
