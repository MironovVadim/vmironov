package ru.job4j.carstorage;

import java.util.List;

/**
 * Car.
 */
public class Car {
    /**
     * Id.
     */
    private int id;
    /**
     * User id.
     */
    private int userId;
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
     * Comments.
     */
    private List<Comment> comments;

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
     * User id getter.
     * @return user id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * User id setter.
     * @param userId - user id.
     */
    public void setUserId(int userId) {
        this.userId = userId;
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
     * Comments getter.
     * @return comments.
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Comments setter.
     * @param comments - comments.
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
