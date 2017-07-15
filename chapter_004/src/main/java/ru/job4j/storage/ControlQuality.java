package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for management food storages.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ControlQuality {
    /**
     * Massif of storages.
     */
    private Storage[] storages;

    /**
     * Default constructor.
     * @param storages - food storages.
     */
    public ControlQuality(Storage... storages) {
        this.storages = storages;
    }

    /**
     * Method check new food and distribute it to storages.
     * @param foodList - food list.
     */
    public void checkFood(List<Food> foodList) {
       for (Storage storage : storages) {
           List<Food> foodForStorage = storage.getFoodForStorage(foodList);
            storage.addFood(foodForStorage);
       }
    }

    /**
     * Method check food in storages and distribute it according current date.
     */
    public void recheckStorages() {
        List<Food> foodFromAllStorages = this.getFoodFromAllStorages();
        for (Storage storage : storages) {
            List<Food> foodForStorage = storage.getFoodForStorage(foodFromAllStorages);
            storage.setFood(foodForStorage);
        }
    }

    /**
     * Method return food from all storages.
     * @return food from all storages.
     */
    private List<Food> getFoodFromAllStorages() {
        List<Food> foodList = new ArrayList<>();
        for (Storage storage : storages) {
            foodList.addAll(storage.getFoodFromStorage());
        }
        return foodList;
    }
}
