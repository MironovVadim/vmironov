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
        this.findTheWayFrom(new Point(srcY, srcX), new ArrayList<>());
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
     * @param currentPoint - класс с координатами ячейки в которой находится лягушка
     * @param path список ячеек, в которых побывала лягушка в одном варианте прохода
     */
    private void findTheWayFrom(Point currentPoint, List<Point> path) {
        boolean isDestination = false;
        int curY = currentPoint.getY();
        int curX = currentPoint.getX();
        path.add(currentPoint);
        if (dstY == curY && dstX == curX) {
            allPaths.add(path.size());
        }
        if (dstY != curY && dstX <= curX) {
            path.remove(currentPoint);
            isDestination = true;
        }
        if (!isDestination && canNextMove(new Point(curY - 2, curX + 2))) {
            this.findTheWayFrom(new Point(curY - 2, curX + 1), path);
        }
        if (!isDestination && canNextMove(new Point(curY - 1, curX + 2))) {
            this.findTheWayFrom(new Point(curY - 1, curX + 2), path);
        }
        if (!isDestination && canNextMove(new Point(curY, curX + 3))) {
            this.findTheWayFrom(new Point(curY, curX + 3), path);
        }
        if (!isDestination && canNextMove(new Point(curY + 1, curX + 2))) {
            this.findTheWayFrom(new Point(curY + 1, curX + 2), path);
        }
        if (!isDestination && canNextMove(new Point(curY + 2, curX + 1))) {
            this.findTheWayFrom(new Point(curY + 2, curX + 1), path);
        }
        if (!isDestination) {
            path.remove(currentPoint);
        }
    }

    /**
     * Метод проверят может ли лягушка совершить прыжок на предполагаемую ячейку.
     * @param nextPoint - класс с координатами следующей ячейки
     * @return true - если ячейка находится в пределах поля, она не занята деревом и ячейка нне находится за ячейкой назначения.
     */
    private boolean canNextMove(Point nextPoint) {
        return isInField(nextPoint) && isPointFree(nextPoint) && !isNewPointLayAfterDstPoint(nextPoint);
    }

    /**
     * Метод проверяет находится ли предполагаемая ячейка в пределах поля.
     * @param nextPoint - класс с координатами следующей ячейки
     * @return true - если ячейка находится в пределах поля; false - если ячейка за пределами поля
     */
    private boolean isInField(Point nextPoint) {
        return 0 <= nextPoint.getX() && field[0].length > nextPoint.getX() && 0 <= nextPoint.getY() && field.length > nextPoint.getY();
    }

    /**
     * Метод проверяет перепрыгнула ли лягушка нужную ячейку или нет.
     * @param nextPoint - класс с координатами следующей ячейки
     * @return true - если nextX дальше координаты X ячейки назначения; false - если nextX раньше координаты X ячейки назначения
     */
    private boolean isNewPointLayAfterDstPoint(Point nextPoint) {
        return dstX < nextPoint.getX();
    }

    /**
     * Метод проверят свободна ли ячейка или нет.
     * @param nextPoint - класс с координатами следующей ячейки
     * @return true - если ячейка свободна; false - если занята деревом
     */
    private boolean isPointFree(Point nextPoint) {
        return field[nextPoint.getY()][nextPoint.getX()] == 0;
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
