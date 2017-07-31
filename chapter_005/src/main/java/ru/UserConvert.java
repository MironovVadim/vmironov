/**
 * Class UserConvert.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru;

import java.util.HashMap;
import java.util.List;

/**
 * Class for converting List in Map.
 */
public class UserConvert {
    /**
     * Convert List<User> in HashMap<Integer, User>.
     * @param list list for converting
     * @return Map after converting list
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
