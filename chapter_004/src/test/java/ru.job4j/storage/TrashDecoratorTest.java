package ru.job4j.storage;


import org.junit.Test;
import ru.job4j.storage.food.Food;
import ru.job4j.storage.food.Fruit;

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
public class TrashDecoratorTest {
    /**
     * Test addFood() method.
     */
    @Test
    public void whenAddReproductedFoodThenGetZeroSizeOfStorage() {
        Storage storage = new Trash();
        Storage trashDecorator = new TrashDecorator(storage);
        long currentTime = System.currentTimeMillis();
        long oneDay = 86400000;
        Fruit fruit = new Fruit("SomeFruit",
                new Date(currentTime - oneDay * 7),
                new Date(currentTime - oneDay), 30, 20, true, false);


        List<Food> foodList = new ArrayList<>();
        foodList.add(fruit);
        List<Food> trashFood = trashDecorator.getFoodForStorage(foodList);
        trashDecorator.addFood(trashFood);
        int result = trashDecorator.getFoodFromStorage().size();
        int expected = 0;
        assertThat(result, is(expected));
    }
}
