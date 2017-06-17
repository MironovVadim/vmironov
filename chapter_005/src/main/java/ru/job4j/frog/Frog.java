/**
 * Frog class.
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.frog;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение тестового задания про лягушку.
 */
public class Frog {
    /**
     * Двумерный массив, который служит полем для прохода лягушки.
     */
    private int[][] field;
    /**
     * Координата Y ячейки назначения.
     */
    private int dstY;
    /**
     * Координата X ячейки назначения.
     */
    private int dstX;
    /**
     * Список хранит количество прыжков необходимых лягушке для того, чтобы добраться до ячейки назначения для каждого удачного прохода от начала до конца.
     */
    private List<Integer> allPaths;

    /**
     * Конструктор принимает двумерный массив, которое служит игровым полем и координаты X, Y ячейки, которая является пунктом назначения.
     * @param field - игровое поле
     * @param dstY - координата Y ячейки назначения
     * @param dstX - координата X ячейки назначения
     */
    public Frog(int[][] field, int dstY, int dstX) {
        this.field = field;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
        this.dstY = dstY;
        this.dstX = dstX;
        allPaths = new ArrayList<>();
    }

    /**
     * Метод добавляет дерево в выбранную ячейку.
     * @param y - координата Y дерева
     * @param x - координата X дерева
     */
    public void addTree(int y, int x) {
        field[y][x] = 1;
    }

    /** Метод вызывает перегруженный вариант метода для нахождения всех вариантов возможных проходов от старта до
     * ячейки назначения и возвращает количество прыжков на самом коротком пути.
     * @param srcY - координата Y начальной ячейки
     * @param srcX - координата X начальной ячейки
     * @return количество шагов на самом коротком удачном проходе до ячейки назначения
     */
    public int findTheWayFrom(int srcY, int srcX) {
        if (dstX < srcX) {
            int tempX = dstX;
            int tempY = dstY;
            dstX = srcX;
            dstY = srcY;
            srcX = tempX;
            srcY = tempY;
        }
        this.findTheWayFrom(srcY, srcX, new ArrayList<>());
        int minLength = -1;
        if (!allPaths.isEmpty()) {
            minLength = allPaths.get(0) - 1;
            for (Integer length : allPaths) {
                if (minLength > length) {
                    minLength = length - 1;
                }
            }
        }
        System.out.println("Всего вариантов прохода: " + allPaths.size());
        return minLength;
    }

    /**
     * Рекурсивный метод для нахождения всех вариантов прохода до ячейки назначения.
     * Также метод заполняет список allPaths всеми возможными случаями
     * удачных проходов от старта до ячейки нахождения (В список попадает только количество прыжков на каждый случай).
     * @param srcY - координата Y ячейки в которой находится лягушка
     * @param srcX - координата X ячейки в которой находится лягушка
     * @param path список ячеек, в которых побывала лягушка в одном варианте прохода
     */
    private void findTheWayFrom(int srcY, int srcX, List<Point> path) {
        boolean isDestination = false;
        Point curPosition = new Point(srcY, srcX);
        path.add(curPosition);
        if (curPosition.getY() == dstY && curPosition.getX() == dstX) {
            allPaths.add(path.size());
        }
        if (dstY != curPosition.getY() && dstX <= curPosition.getX()) {
            path.remove(curPosition);
            isDestination = true;
        }
        if (!isDestination && canNextMove(srcY - 2, srcX + 1)) {
            this.findTheWayFrom(srcY - 2, srcX + 1, path);
        }
        if (!isDestination && canNextMove(srcY - 1, srcX + 2)) {
            this.findTheWayFrom(srcY - 1, srcX + 2, path);
        }
        if (!isDestination && canNextMove(srcY, srcX + 3)) {
            this.findTheWayFrom(srcY, srcX + 3, path);
        }
        if (!isDestination && canNextMove(srcY + 1, srcX + 2)) {
            this.findTheWayFrom(srcY + 1, srcX + 2, path);
        }
        if (!isDestination && canNextMove(srcY + 2, srcX + 1)) {
            this.findTheWayFrom(srcY + 2, srcX + 1, path);
        }
        if (!isDestination) {
            path.remove(curPosition);
        }
    }

    /**
     * Метод проверят может ли лягушка совершить прыжок на предполагаемую ячейку.
     * @param nextY - координата Y предполагаемой ячейки
     * @param nextX - координата X предполагаемой ячейки
     * @return true - если ячейка находится в пределах поля, она не занята деревом и ячейка нне находится за ячейкой назначения.
     */
    private boolean canNextMove(int nextY, int nextX) {
        return isInField(nextY, nextX) && isPointFree(nextY, nextX) && !isNewPointLayAfterDstPoint(nextX);
    }

    /**
     * Метод проверяет находится ли предполагаемая ячейка в пределах поля.
     * @param nextY - координата Y предполагаемой ячейки
     * @param nextX - координата X предполагаемой ячейки
     * @return true - если ячейка находится в пределах поля; false - если ячейка за пределами поля
     */
    private boolean isInField(int nextY, int nextX) {
        return 0 <= nextX && field[0].length > nextX && 0 <= nextY && field.length > nextY;
    }

    /**
     * Метод проверяет перепрыгнула ли лягушка нужную ячейку или нет.
     * @param nextX - координата X проверяемой ячейки
     * @return true - если nextX дальше координаты X ячейки назначения; false - если nextX раньше координаты X ячейки назначения
     */
    private boolean isNewPointLayAfterDstPoint(int nextX) {
        return dstX < nextX;
    }

    /**
     * Метод проверят свободна ли ячейка или нет.
     * @param nextY - координата Y
     * @param nextX - координата X
     * @return true - если ячейка свободна; false - если занята деревом
     */
    private boolean isPointFree(int nextY, int nextX) {
        return field[nextY][nextX] == 0;
    }
}

/**
 * Класс хранящий координаты X и Y ячейки массива.
 */
class Point {
    /**
     * Координата X.
     */
    private int x;
    /**
     * Координата Y.
     */
    private int y;

    /**
     * Конструктор принимающий 2 координаты.
     * @param y - координата Y.
     * @param x - координата X.
     */
    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }

    /**
     * X Getter.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Y Getter.
     * @return y
     */
    public int getY() {
        return y;
    }
}
