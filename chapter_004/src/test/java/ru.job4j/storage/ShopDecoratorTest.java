package ru.job4j.storage;


import org.junit.Test;
import ru.job4j.storage.food.Food;
import ru.job4j.storage.food.Fruit;
import ru.job4j.storage.food.Meat;

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
public class ShopDecoratorTest {
    /**
     * Test getFoodFromStorage method.
     */
    @Test
    public void whenAddReproductedFoodGetOneItemInStorage() {
        Storage storage = new Shop();
        Storage shopDecorator = new ShopDecorator(storage);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay * 6), 30, 20, true, false);
        shopDecorator.addFood(Arrays.asList(fruit));
        List<Food> result = shopDecorator.getFoodFromStorage();
        List<Food> expected = Arrays.asList(fruit);
        assertThat(result, is(expected));
    }

    /**
     * Test getFoodFromStorage method.
     */
    @Test
    public void whenAddFoodGetOneItemInStorage() {
        Storage storage = new Shop();
        Storage shopDecorator = new ShopDecorator(storage);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay * 6), 30, 20, true, false);
        Meat meat = new Meat("SomeMeat",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay * 6), 140,  40, false, true);
        List<Food> foodList = new ArrayList<>(Arrays.asList(fruit, meat));
        List<Food> result = shopDecorator.getFoodForStorage(foodList);
        List<Food> expected = Arrays.asList(fruit);
        assertThat(result, is(expected));
    }
}
