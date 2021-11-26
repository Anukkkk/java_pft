package ru.stqa.pft.sandbox;

public class Point {
    public double a1;
    public double b2;

    public Point(double a, double b) {
        this.a1 = a;
        this.b2 = b;
    }

    public double distance() {
        return this.b2 - this.a1;
    }
}
