package ru.job4j.servlets;

import java.util.List;

/**
 * Controller of DB.
 *  * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface DBController {
    /**
     * Возвращает строковый результат с user'ом из БД.
     * @param id user'а
     * @return строковый результат запроса
     */
   List<String> get();

    /**
     * Метод добавляет нового user'a в БД.
     * @param name - имя нового user'a
     * @param login - логин нового user'a
     * @param email - почта новго user'a
     */
    void post(String name, String login, String email);

    /**
     * Обновляет почту у выбранного user'a в БД.
     * @param email - новая почта
     * @param name - имя user'a для обновления его почты.
     */
    void put(String email, String name);

    /**
     * Метод удаляет user'a по имени.
     * @param name - имя удаляемого user'a
     */
    void delete(String name);
}
