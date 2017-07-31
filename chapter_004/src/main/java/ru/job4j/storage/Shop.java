package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shop with food.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Shop implements Storage {
    /**
     * Food storage.
     */
    private List<Food> foodStorage = new ArrayList<>();

    /**
     * Method pull out list of food that matches conditions for current storage.
     * If food have left time less then 25% method add discount to food.
     * @param foodList - list with all kind of food.
     * @return List of food for current storage.
     */
    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        List<Food> shopFood = foodList.stream().filter(value -> {
            boolean result = false;
            int leftTime = this.leftTime(value);
            if (25 <= leftTime && 75 > leftTime) {
                result = true;
            } else if (75 <= leftTime && 100 > leftTime) {
                if (!value.isDiscounted()) {
                    value.considerDiscount();
                }
                result = true;
            }
            return result;
        }).collect(Collectors.toList());
        foodList.removeAll(shopFood);
        return shopFood;
    }

    @Override
    public List<Food> getFoodFromStorage() {
        return foodStorage;
    }

    @Override
    public void setFood(List<Food> foodList) {
        this.foodStorage = foodList;
    }

    @Override
    public void addFood(List<Food> foodList) {
        foodStorage.addAll(foodList);
    }
}
