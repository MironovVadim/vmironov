package ru.job4j.servlets;

import java.sql.ResultSet;

/**
 * Controller of DB.
 */
public interface DBController {
    /**
     * Возвращает ResultSet с user'ом из БД.
     * @param id user'а
     * @return результат запросы в БД
     */
   ResultSet get(int id);

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
