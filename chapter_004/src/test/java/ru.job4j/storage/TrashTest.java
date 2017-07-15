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
 */
public class TrashTest {
    /**
     * Test getFoodForStorage() method.
     */
    @Test
    public void whenCheckFiveItemsThenGetOneItemsInStorage() {
        Trash trash = new Trash();
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        List<Food> foodList = new ArrayList<>();
        Milk milk1 = new Milk("SomeMilk",
                new Date(currentTime - oneDay * 4),
                new Date(currentTime + oneDay * 6), 100, 35);
        Milk milk2 = new Milk("SomeMilkToo",
                new Date(currentTime - oneDay * 6),
                new Date(currentTime + oneDay), 80, 35);
        Meat meat = new Meat("SomeMeat", new Date(currentTime - oneDay),
                new Date(currentTime + oneDay * 11), 200, 50);
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay), 30, 20);
        foodList.add(milk1);
        foodList.add(milk2);
        foodList.add(meat);
        foodList.add(fruit);
        List<Food> result = trash.getFoodForStorage(foodList);
        List<Food> expected = new ArrayList<>();
        expected.add(fruit);
        assertThat(result, is(expected));
    }
}
