package ru.job4j.storage;

import org.junit.Test;
import ru.job4j.storage.food.Food;
import ru.job4j.storage.food.Fruit;
import ru.job4j.storage.food.Meat;
import ru.job4j.storage.food.Milk;

import java.util.ArrayList;
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
public class ShopTest {
    /**
     * Test getFoodForStorage() method.
     */
    @Test
    public void whenCheckFiveItemsThenGetTwoItemsInStorage() {
        Storage shop = new Shop();
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        List<Food> foodList = new ArrayList<>();
        Milk milk1 = new Milk("SomeMilk",
                new Date(currentTime - oneDay * 4),
                new Date(currentTime + oneDay * 6), 100, 35, false, true);
        Milk milk2 = new Milk("SomeMilkToo",
                new Date(currentTime - oneDay * 6),
                new Date(currentTime + oneDay), 80, 35, false, true);
        Meat meat = new Meat("SomeMeat", new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50, false, true);
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay), 30, 20, true, false);
        foodList.add(milk1);
        foodList.add(milk2);
        foodList.add(meat);
        foodList.add(fruit);
        List<Food> result = shop.getFoodForStorage(foodList);
        List<Food> expected = new ArrayList<>();
        expected.add(milk1);
        expected.add(milk2);
        assertThat(result, is(expected));
    }
}
