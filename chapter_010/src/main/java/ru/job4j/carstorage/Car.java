package ru.job4j.carstorage;

import java.util.HashSet;
import java.util.Set;

/**
 * Car.
 */
public class Car {
    /**
     * Id.
     */
    private int id;
    /**
     * Car owner.
     */
    private User user;
    /**
     * Mark.
     */
    private String mark;
    /**
     * Model.
     */
    private String model;
    /**
     * Release year.
     */
    private int releaseYear;
    /**
     * Mileage.
     */
    private int mileage;
    /**
     * Body type.
     */
    private String bodyType;
    /**
     * Color.
     */
    private String color;
    /**
     * Engine capacity.
     */
    private double engineCapacity;
    /**
     * Engine type.
     */
    private String engineType;
    /**
     * Power.
     */
    private int power;
    /**
     * Cost.
     */
    private int cost;
    /**
     * Is car sold.
     */
    private boolean sold;
    /**
     * Description.
     */
    private String description;
    /**
     * Comments.
     */
    private Set<Comment> comments = new HashSet<>();

    /**
     * Id getter.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * User getter.
     * @return user.
     */
    public User getUser() {
        return user;
    }

    /**
     * User setter.
     * @param user - user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Mark getter.
     * @return mark.
     */
    public String getMark() {
        return mark;
    }

    /**
     * Mark setter.
     * @param mark - mark.
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * Model getter.
     * @return model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Model setter.
     * @param model - model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Release year getter.
     * @return release year.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Release year setter.
     * @param releaseYear - release year.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Mileage getter.
     * @return mileage.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Mileage setter.
     * @param mileage - mileage.
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Body type getter.
     * @return body type.
     */
    public String getBodyType() {
        return bodyType;
    }

    /**
     * Body type setter.
     * @param bodyType - body type.
     */
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Color setter.
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Color setter.
     * @param color - color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Engine capacity getter.
     * @return engine capacity.
     */
    public double getEngineCapacity() {
        return engineCapacity;
    }

    /**
     * Engine capacity setter.
     * @param engineCapacity - engine capacity.
     */
    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    /**
     * Engine type getter.
     * @return engine type.
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Engine type setter.
     * @param engineType - engine type.
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Power getter.
     * @return power.
     */
    public int getPower() {
        return power;
    }

    /**
     * Power setter.
     * @param power - power.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Cost getter.
     * @return cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Cost setter.
     * @param cost - cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * Description getter.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description setter.
     * @param description - description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Comments getter.
     * @return comments.
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Comments setter.
     * @param comments - comments.
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (releaseYear != car.releaseYear) return false;
        if (mileage != car.mileage) return false;
        if (Double.compare(car.engineCapacity, engineCapacity) != 0) return false;
        if (power != car.power) return false;
        if (cost != car.cost) return false;
        if (sold != car.sold) return false;
        if (!user.equals(car.user)) return false;
        if (!mark.equals(car.mark)) return false;
        if (!model.equals(car.model)) return false;
        if (!bodyType.equals(car.bodyType)) return false;
        if (!color.equals(car.color)) return false;
        if (!engineType.equals(car.engineType)) return false;
        return comments.equals(car.comments);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + mark.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + releaseYear;
        result = 31 * result + mileage;
        result = 31 * result + bodyType.hashCode();
        result = 31 * result + color.hashCode();
        temp = Double.doubleToLongBits(engineCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + engineType.hashCode();
        result = 31 * result + power;
        result = 31 * result + cost;
        result = 31 * result + (sold ? 1 : 0);
        result = 31 * result + comments.hashCode();
        return result;
    }
}
