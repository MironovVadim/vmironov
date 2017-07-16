package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Food;
import ru.job4j.storage.food.Fruit;
import ru.job4j.storage.food.Meat;
import ru.job4j.storage.food.Milk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class WarehouseDecoratorTest {
    /**
     * Test adding food to fridge.
     */
    @Test
    public void whenAddFoodForFridgeGetTwoItemsFromFridge() {
        Storage warehouse = new Warehouse();
        WarehouseDecorator warehouseDecorator = new WarehouseDecorator(warehouse, 10);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Milk milk1 = new Milk("SomeMilk",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 6), 100, 35, false, true);
        Meat meat = new Meat("SomeMeat",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50, false, true);
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay),
                new Date(currentTime - oneDay * 7), 30, 20, true, false);
        List<Food> foodList = new ArrayList<>();
        foodList.add(milk1);
        foodList.add(meat);
        foodList.add(fruit);
        warehouseDecorator.addFood(foodList);
        List<Food> result = warehouseDecorator.getFridge();
        List<Food> expected = Arrays.asList(milk1, meat);
        assertThat(result, is(expected));
    }

    /**
     * Test adding food to additional storage.
     */
    @Test
    public void whenAddSixFoodInStorageGetTwoItemsFromAdditionalStorage() {
        Storage warehouse = new Warehouse();
        WarehouseDecorator storage = new WarehouseDecorator(warehouse, 4);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Milk milk1 = new Milk("SomeMilk",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 6), 100, 35, false, true);
        Milk milk2 = new Milk("SomeMilk",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 6), 100, 35, false, true);
        Meat meat1 = new Meat("SomeMeat",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50, false, true);
        Meat meat2 = new Meat("SomeMeat",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50, false, true);
        Fruit fruit1 = new Fruit("SomeFruit",
                new Date(currentTime - oneDay),
                new Date(currentTime - oneDay * 7), 30, 20, true, false);
        Fruit fruit2 = new Fruit("SomeFruit",
                new Date(currentTime - oneDay),
                new Date(currentTime - oneDay * 7), 30, 20, true, false);
        List<Food> foodList = new ArrayList<>();
        foodList.add(milk1);
        foodList.add(milk2);
        foodList.add(meat1);
        foodList.add(meat2);
        foodList.add(fruit1);
        foodList.add(fruit2);
        List<Food> storageFood = storage.getFoodForStorage(foodList);
        storage.addFood(storageFood);
        List<Food> result = storage.getAdditionalStorage();
        List<Food> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(fruit1, fruit2));
        assertThat(result, is(expected));
    }
}
