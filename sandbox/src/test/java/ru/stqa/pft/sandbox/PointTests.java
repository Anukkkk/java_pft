package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint (){
        Point p1 = new Point(4, 6);
        Point p2 = new Point(5, 7);
        Assert.assertEquals(Dist.distance(p1,p2), 2.8284271247461903);
    }
    @Test
    public void testPoint1(){
        Point p1 = new Point(-5, 0);
        Point p2 = new Point(0, -5);
        Assert.assertEquals(Dist.distance(p1,p2), 7.0710678118654755);
    }

    @Test
    public void testPoint2(){
        Point p1 = new Point(-5, -0.5);
        Point p2 = new Point(0.9, -5);
        Assert.assertEquals(Dist.distance(p1,p2), 7.420242583635659);
    }
}
