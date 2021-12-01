package ru.stqa.pft.sandbox;

public class MyFirst {

    public static void main(String[] args) {
        Point a = new Point(4, 6);
        Point b = new Point(5, 7);
        System.out.println("Расстояние между двумя точками равно " + Point.distance(a, b));
    }
}