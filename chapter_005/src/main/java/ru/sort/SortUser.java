/**
 * UserSort class.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.sort;

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
        Collections.sort(list, Comparator.comparingInt(User::hashCode));
        return list;
    }

    /**
     * Sort list with comparator by name length.
     * @param list for sorting
     * @return list after sorting
     */
    public List<User> sortLength(List<User> list) {
        Collections.sort(list, Comparator.comparingInt(User::getStringLength));
        return list;
    }
}