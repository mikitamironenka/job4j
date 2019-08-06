package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distanceOne() {

        int x1 = 0, x2 = 0, y1 = 2, y2 = 0;
        double expectedDistance = 2.0;
        double out = Point.distance(x1, x2, y1, y2);

        Assert.assertEquals(expectedDistance, out, 0);

    }

    @Test
    public void distanceTwo() {

        int x1 = -1, x2 = -2, y1 = 2, y2 = 2;
        double expectedDistance = 5.0;
        double out = Point.distance(x1, x2, y1, y2);

        Assert.assertEquals(expectedDistance, out, 0);

    }
}
