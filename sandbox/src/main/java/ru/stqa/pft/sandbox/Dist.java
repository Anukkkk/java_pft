package ru.stqa.pft.sandbox;

public class Dist {
    public static double distance(Point p1, Point p2) {
        return (Math.sqrt(p1.distance() * p1.distance() + p2.distance() * p2.distance()));
    }
}
