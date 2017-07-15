package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WareHouse for food.
 */
public class Warehouse implements Storage {
    /**
     * Food storage.
     */
    private List<Food> foodStorage = new ArrayList<>();

    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        List<Food> wareHouseFood = foodList.stream().filter(value -> {
            int leftTime = this.leftTime(value);
            return 25 > leftTime;
        }).collect(Collectors.toList());
        foodList.removeAll(wareHouseFood);
        return wareHouseFood;
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
