package ru.job4j.testtask;

/**
 *  Алгоритм такой:
 *  Первый if (если это не крайняя ячейка и слева нуль, то идем влево(внутренний if (если нуль в нижней ячейке,
 *  то создаем узел(Cell(x, y) для возврата к нему в случае, если робот зайдет в тупик)).
 *  Второй else if (если данная ячейка не является крайней, то двигаемся вниз).
 *  Третий else (если робот в тупике, то вернуться к последнему узлу и спуститься на ячейку вниз).
 *  Последний if (если достигнута последняя ячейка, выходим из цикла и возвращаем boolean result).
 *
 *  Вместо заполнения ячеек другой цифрой, по которому робот проходит, я вывожу в консоль ячейки в которых робот побывал.
 */
public class Robot {

    private int[][] board;
    /**
     * Массив узлов.
     */
    private Cell[] cells;

    private int x = 0;
    private int y = 0;
    /**
     * Индекс для массива (коллекции ведь пока не используем).
     */
    private int index = 1;

    /**
     *
     * Инициализируем массив узлов и добавляем узлы Cell(-1, -1) для условия выхода с цикла и Cell(0, 0) для
     * возможности вернуться 1 раз в начало, если в самом начале был выбран не верный путь.
     */
    public Robot(int[][] board) {
        this.board = board;
        cells = new Cell[board.length * board[0].length];
        cells[0] = new Cell(-1, -1);
        cells[1] = new Cell(0, 0);
    }

    public void addCell(Cell cell) {
        cells[index++] = cell;
    }

    public Cell getCell() {
        return cells[--index];
    }

    public boolean start() {
        boolean result = false;
        do {
            if (y < board.length - 1 && board[x][y + 1] == 0) {
                if (x < board.length - 1 && board[x + 1][y] == 0) {
                    addCell(new Cell(x, y));
                }
                y++;
            } else if (x < board.length - 1 && board[x + 1][y] == 0) {
                x++;
            } else {
                Cell cell = getCell();
                x = cell.getX() + 1;
                y = cell.getY();
            }
            System.out.println(String.format("%d, %d", x, y));
            if (x == board.length - 1 && y == board.length - 1) {
                result = true;
                break;
            }
        } while (x != 0 && y != -1);
        return result;
    }

    public static void main(String[] args) {
        int[][] square = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] square2 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0}};
        Robot robot = new Robot(square2);
        System.out.println(robot.start());
    }
}

class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}