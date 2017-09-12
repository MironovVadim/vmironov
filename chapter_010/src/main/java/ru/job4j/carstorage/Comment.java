package ru.job4j.carstorage;

import java.util.Date;

/**
 * Car comment.
 */
public class Comment implements Comparable {
    /**
     * Comment id.
     */
    private int id;
    /**
     * Comment of user id.
     */
    private User user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (carId != comment.carId) return false;
        if (!user.equals(comment.user)) return false;
        if (!description.equals(comment.description)) return false;
        return created.equals(comment.created);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + carId;
        result = 31 * result + description.hashCode();
        result = 31 * result + created.hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.getCreated().getTime() - ((Comment) o).getCreated().getTime());
    }
}
