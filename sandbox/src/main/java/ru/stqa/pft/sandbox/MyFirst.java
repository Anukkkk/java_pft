package ru.stqa.pft.sandbox;

public class MyFirst {

    public static void main(String[] args) {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(5, 7);
        System.out.println("Расстояние между двумя точками равно " + Dist.distance(p1, p2));
    }
}