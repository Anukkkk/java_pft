package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint (){
        Point p1 = new Point(4, 6);
        Point p2 = new Point(5, 7);
        Assert.assertEquals(Point.distance(p1, p2), 1.4142135623730951);
        Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
    }
    @Test
    public void testPoint1(){
        Point p1 = new Point(-5, 0);
        Point p2 = new Point(0, -5);
        Assert.assertEquals(Point.distance(p1, p2), 7.0710678118654755);
        Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
    }

    @Test
    public void testPoint2(){
        Point p1 = new Point(-5, -0.5);
        Point p2 = new Point(0.9, -5);
        Assert.assertEquals(Point.distance(p1, p2), 7.420242583635659);
        Assert.assertEquals(p1.distance(p2), 7.420242583635659);
    }
}
