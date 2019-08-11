package ru.job4j.condition;

import static java.lang.Math.*;

public class Point {

    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

//    public static void main(String[] args) {
//        double result = distance(0, 0, 2, 0);
//        System.out.println("result (0, 0) to (2, 0) " + result);
//        result = distance(0, 0, 2, 2);
//        System.out.println("result (0, 0) to (2, 2) " + result);
//        result = distance(1, 2, 5, 7);
//        System.out.println("result (1, 2) to (5, 7) " + result);
//        result = distance(-1, -2, 2, 2);
//        System.out.println("result (-1, -2) to (2, 2) " + result);
//    }

}
