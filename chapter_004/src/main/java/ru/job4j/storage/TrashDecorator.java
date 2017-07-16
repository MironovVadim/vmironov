package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Trash Decorator.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrashDecorator extends StorageDecorator {
    /**
     * Default Constructor.
     * @param foodStorage - inherited storage.
     */
    public TrashDecorator(Storage foodStorage) {
        super(foodStorage);
    }

    @Override
    public List<Food> getFoodForStorage(List<Food> foodList) {
        List<Food> trashFood = super.getFoodForStorage(foodList);
        List<Food> reproductedFood = trashFood.stream().filter(value -> value.isCanReproduct()).collect(Collectors.toList());
        trashFood.removeAll(reproductedFood);
        foodList.addAll(reproductedFood);
        return trashFood;
    }
}
