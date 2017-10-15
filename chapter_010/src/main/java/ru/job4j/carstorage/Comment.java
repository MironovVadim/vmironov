package ru.job4j.carstorage;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Car comment.
 */
@JsonAutoDetect
public class Comment implements Comparable<Comment> {
    /**
     * Comment id.
     */
    @JsonIgnore
    private int id;
    /**
     * Comment of user id.
     */
    private User user;

    /**
     * Description.
     */
    private String description;
    /**
     * time of creating.
     */
    private Date created;

    /**
     * Default constructor.
     */
    public Comment() {
    }

    /**
     * Second constructor with initialization fields.
     * @param user of comment.
     * @param description of comment.
     * @param created date of comment.
     */
    public Comment(User user, String description, Date created) {
        this.user = user;
        this.description = description;
        this.created = created;
    }

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Comment comment = (Comment) o;

        if (id != comment.id) {
            return false;
        }
        if (!user.equals(comment.user)) {
            return false;
        }
        if (!description.equals(comment.description)) {
            return false;
        }
        return created.equals(comment.created);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + created.hashCode();
        return result;
    }

    @Override
    public int compareTo(Comment o) {
        return (int) (this.getCreated().getTime() - o.getCreated().getTime());
    }

    @Override
    public String toString() {
        return "Comment{"
                + "id=" + id
                + ", user=" + user
                + ", description='" + description + '\''
                + ", created=" + created
                + '}';
    }
}