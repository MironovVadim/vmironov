package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Shop Decorator.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ShopDecorator extends StorageDecorator {
    /**
     * Default constructor.
     * @param foodStorage - inherited storage.
     */
    public ShopDecorator(Storage foodStorage) {
        super(foodStorage);
    }

    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        List<Food> shopFood = this.getFoodForStorage(foodList);
        List<Food> reproductedFood = foodList.stream().filter(value -> 100 <= this.leftTime(value) && value.isCanReproduct()).collect(Collectors.toList());
        foodList.removeAll(reproductedFood);
        shopFood.addAll(reproductedFood);
        return shopFood;
    }
}
