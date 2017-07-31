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
 */
public class ControlQualityTest {
    /**
     * Test checkFood(List) method.
     */
    @Test
    public void whenCheckFoodItemsThenFourItemsFromStorage() {
        Storage shop = new Shop();
        Storage shopDecorator = new ShopDecorator(shop);
        Storage trash = new Trash();
        Storage trashDecorator = new TrashDecorator(trash);
        ControlQuality quality = new ControlQuality(shopDecorator, trashDecorator);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Milk milk1 = new Milk("SomeMilk",
                new Date(currentTime - oneDay * 4),
                new Date(currentTime + oneDay * 6), 100, 35, false, true);
        Milk milk2 = new Milk("SomeMilkToo",
                new Date(currentTime - oneDay * 6),
                new Date(currentTime + oneDay), 80, 35, false, true);
        Meat meat = new Meat("SomeMeat",
                new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50, false, true);
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay), 30, 20, true, false);
        Fruit fruit2 = new Fruit("SomeFruitTwo",
                new Date(currentTime - oneDay * 4),
                new Date(currentTime - oneDay), 20, 10, false, false);
        List<Food> foodList = new ArrayList<>(Arrays.asList(milk1, milk2, meat, fruit, fruit2));
        quality.checkFood(foodList);
        List<Food> result = quality.getFoodFromAllStorages();
        List<Food> expected = Arrays.asList(milk1, milk2, fruit, fruit2);
        assertThat(result, is(expected));
    }
}