/**
 * Class Item.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

import java.util.Random;

/**
 * Class Item.
 */
public class Item {
    /**
     * Random number to generate item id.
     */
    private static Random random = new Random();
    /**
     * Id.
     */
    private String id;
    /**
     * Name.
     */
    private String name;
    /**
     * Description.
     */
    private String desc;
    /**
     * Creation time.
     */
    private long created;
    /**
     * Comments massif.
     */
    private String[] comments;

    /**
     * Constructor.
     * @param name - name of object
     * @param desc - description of object
     */
    public Item(String name, String desc) {
        this.id = generateId();
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
    }

    /**
     * Id getter.
     * @return String - item id
     */
    public String getId() {
        return id;
    }

    /**
     * Id setter.
     * @param id -  item id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name getter.
     * @return String - name
     */
    public String getName() {
        return name;
    }

    /**
     * Description getter.
     * @return String - desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter of creation date.
     * @return long - creation date
     */
    public long getCreated() {
        return created;
    }

    /**
     * Comments getter.
     * @return String[] - comments
     */
    public String[] getComments() {
        return comments;
    }

    /**
     * Set any comments.
     * @param comments - comments of item
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * Generator item id.
     * @return String - item id
     */
    private String generateId() {
        return Long.toString(System.currentTimeMillis() + random.nextInt(100));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) {
            return false;
        }
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", desc='" + desc + '\''
                + '}';
    }
}
