package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Trash for expire food.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Trash implements Storage {
    /**
     * Food Storage.
     */
    private List<Food> foodStorage = new ArrayList<>();

    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        List<Food> trashFood = foodList.stream().filter(value -> {
            int leftTime = this.leftTime(value);
            return 100 <= leftTime;
        }).collect(Collectors.toList());
        foodList.removeAll(trashFood);
        return trashFood;
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
