/**
 * Class Item.
 *
 * @author Vadim Mironov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.tracker;

/**
 * Class Item.
 */
public class Item {
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
     * @param id - id of this object
     * @param name - name of object
     */
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Id getter.
     * @return String - id
     */
    public String getId() {
        return id;
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
}