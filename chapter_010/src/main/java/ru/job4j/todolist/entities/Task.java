package ru.job4j.todolist.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * DB entity.
 */
@JsonAutoDetect
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * Description.
     */
    @Column(name = "description")
    private String desc;
    /**
     * Create date.
     */
    @Column(name = "created_date")
    private Date created;
    /**
     * Is task done.
     */
    @Column(name = "isdone")
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