package ru.job4j.carstorage;

import java.util.Date;

/**
 * Car comment.
 */
public class Comment {
    /**
     * Comment id.
     */
    private int id;
    /**
     * Comment of user id.
     */
    private int userId;
    /**
     * Comment of car id.
     */
    private int carId;
    /**
     * Description.
     */
    private String description;
    /**
     * time of creating.
     */
    private Date created;

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
     * Car id getter.
     * @return car id.
     */
    public int getCarId() {
        return carId;
    }

    /**
     * Car setter.
     * @param carId - car id.
     */
    public void setCarId(int carId) {
        this.carId = carId;
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
     * Created date getter.
     * @return date of create.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Created date setter.
     * @param created date.
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}
