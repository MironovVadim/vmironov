/**
 * Class with answers and questions.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.testtask;

/**
 * Some class.
 */
public class ControlQuestion {
    /**
     * В случае если у нас есть 2 отсортировынных массива и их надо объединить в 1 отсортированный массив, то алгоритм будет такой:
     * for (int i = 0, j = 0, t = 0; i < firstMassif.length || j < secondMassif.length; t++) {
     *     if (firstMassif[i] < secondMassif[j]) {
     *         resultMassif[t] = firstMassif[i++];
     *     } else {
     *         resultMassif[t] = secondMassif[j++];
     *     }
     * }
     * затем в resultMassif включить оставшиеся значения из наиболее длинного массива.
     */

    /**
     * с != null & c.has()
     * c != null && c.has()
     * Вроде вопрос был такой "Что будет, если в выражении с != null & c.has()   с не будет равна null?"
     * ответ: с и с.has(c) должны быть подходящими типами для побитового сравнения.
     * если вопрос не такой, прошу подправить.
     *
     */

    /**
     * Вопрос о метках.
     * Имеются вложенные друг в друга циклы, как грамотно вернуться из внутренеего во внешний без меток?
     * Ниже код, который был принят по проекту в тестовом задании "Создать программу проверяющую, что строка sub является подстрокой origin.".
     * Еще ниже код с использованием меток.

    public boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        for (int i = 0; i < originArray.length - subArray.length; i++) {
            if (originArray[i] == subArray[0]) {
                boolean isContains = true;
                for (int j = i + 1, t = 1; t < subArray.length; j++, t++) {
                    if (originArray[j] != subArray[t]) {
                        isContains = false;
                        break;
                    }
                }
                if (isContains) {
                    return true;
                }
            }
        }
        return false;
    }
    */

    /**
     * Такой вариант с меткой я изначально написал.

    public boolean containsWithLable(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        label: for (int i = 0; i < originArray.length - subArray.length; i++) {
            if (originArray[i] == subArray[0]) {
                for (int j = i + 1, t = 1; t < subArray.length; j++, t++) {
                    if (originArray[j] != subArray[t]) {
                        continue label;
                    }
                }
                return true;
            }
        }
        return false;
    }
     */
}
