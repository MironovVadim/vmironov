package ru.job4j.todolist;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * DB entity.
 */
@JsonAutoDetect
public class Task {
    /**
     * id.
     */
    private int id;
    /**
     * Description.
     */
    private String desc;
    /**
     * Create date.
     */
    private Date created;
    /**
     * Is task done.
     */
    private boolean done;

    /**
     * Id getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     *
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Description getter.
     *
     * @return description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Description setter.
     *
     * @param desc - description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Create Date getter.
     *
     * @return create date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Create date setter.
     *
     * @param created - new Date.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Status getter.
     *
     * @return is done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Status setter.
     *
     * @param done - new status.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}