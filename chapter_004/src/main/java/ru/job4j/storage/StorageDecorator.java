package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.List;

/**
 * StorageDecorator class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class StorageDecorator implements Storage {
    /**
     * Food storage.
     */
    private Storage foodStorage;

    /**
     * Default constructor.
     * @param foodStorage - inherited storage.
     */
    public StorageDecorator(Storage foodStorage) {
        this.foodStorage = foodStorage;
    }

    /**
     * Method return list with food that matches conditions of current storage.
     * @param foodList - list with all food.
     * @return list with food that matches conditions of current storage.
     */
    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        return foodStorage.getFoodForStorage(foodList);
    }

    @Override
    public List<Food> getFoodFromStorage() {
        return this.foodStorage.getFoodFromStorage();
    }

    @Override
    public void setFood(List<Food> foodList) {
        this.foodStorage.setFood(foodList);
    }

    @Override
    public void addFood(List<Food> foodList) {
        this.foodStorage.addFood(foodList);
    }
}
