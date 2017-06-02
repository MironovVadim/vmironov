/**
 * UserSort class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.sort;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * SortUser class.
 */
public class SortUser {
    /**
     * Convert List To Set.
     * @param list for converting
     * @return Set after converting
     */
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>();
        set.addAll(list);
        return set;
    }

    /**
     * Sort list with comparator by hashcode.
     * @param list for sorting
     * @return list after sorting
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });
        return list;
    }

    /**
     * Sort list with comparator by name length.
     * @param list for sorting
     * @return list after sorting
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getStringLength(), o2.getStringLength());
            }
        });
        return list;
    }
}
