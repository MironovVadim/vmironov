package ru.job4j.storage;

import ru.job4j.storage.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Warehouse Decorator.
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class WarehouseDecorator extends StorageDecorator {
    /**
     * Additional storage.
     */
    private List<Food> additionalStorage = new ArrayList<>();
    /**
     * Fridge.
     */
    private List<Food> fridge = new ArrayList<>();
    /**
     * Capacity of inherited storage.
     */
    private int capacityOfInheritedStorage;

    /**
     * Default constructor.
     * @param foodStorage - inherited storage.
     * @param capacityOfInheritedStorage - capacity of inherited storage.
     */
    public WarehouseDecorator(Storage foodStorage, int capacityOfInheritedStorage) {
        super(foodStorage);
        this.capacityOfInheritedStorage = capacityOfInheritedStorage;
    }

    /**
     * Method return food from fridge, addition storage and inherited storage.
     * @return list with all storaged food.
     */
    @Override
    public List<Food> getFoodFromStorage() {
        List<Food> allFoodList = new ArrayList<>();
        allFoodList.addAll(this.fridge);
        allFoodList.addAll(this.additionalStorage);
        allFoodList.addAll(super.getFoodFromStorage());
        return allFoodList;
    }

    /**
     * Method distribute food between fridge, addition storage and inherited storage.
     * @param foodList - food for adding in food ru.job4j.storage.
     */
    @Override
    public void setFood(List<Food> foodList) {
        this.fridge = this.getFoodForFridge(foodList);
        this.setFood(foodList);
        this.additionalStorage = this.getFoodForInheritedStorage(foodList);
    }

    /**
     * Method adds food between fridge, addition storage and inherited storage.
     * @param foodList - food for adding in food ru.job4j.storage.
     */
    @Override
    public void addFood(List<Food> foodList) {
        List<Food> fridgedFood = this.getFoodForFridge(foodList);
        this.fridge.addAll(fridgedFood);
        List<Food> inheritedStorageFood = this.getFoodForInheritedStorage(foodList);
        super.addFood(inheritedStorageFood);
        this.additionalStorage.addAll(foodList);
    }

    /**
     * Capacity of inherited storage.
     * @return capacity of inherited storage.
     */
    public int getCapacityOfInheritedStorage() {
        return capacityOfInheritedStorage;
    }

    /**
     * Additional storage getter.
     * @return additional storage.
     */
    public List<Food> getAdditionalStorage() {
        return additionalStorage;
    }

    /**
     * Fridge.
     * @return fridge.
     */
    public List<Food> getFridge() {
        return fridge;
    }

    /**
     * Methods removes from foodList and then return list with food for inherited storage.
     * @param foodList - list with all food.
     * @return list with food for inherited storage.
     */
    private List<Food> getFoodForInheritedStorage(List<Food> foodList) {
        int sizeOfInheritedStorage = this.getFoodFromStorage().size();
        List<Food> foodForInheritedStorage = new ArrayList<>();
        for (int i = 0; i < Math.min(capacityOfInheritedStorage - sizeOfInheritedStorage, foodList.size()); i++) {
            foodForInheritedStorage.add(foodList.remove(0));
        }
        return foodForInheritedStorage;
    }

    /**
     * Methods removes from foodList and then return list with food for fridge.
     * @param foodList - list with all food.
     * @return list with food for fridge.
     */
    private List<Food> getFoodForFridge(List<Food> foodList) {
        List<Food> foodForColdStorage = foodList.stream().filter(Food::isColdStorage).collect(Collectors.toList());
        foodList.removeAll(foodForColdStorage);
        return foodForColdStorage;
    }
}
