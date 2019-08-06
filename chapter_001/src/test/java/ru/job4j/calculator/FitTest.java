package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {

        int manWeight = 175;
        double exceptedWeight = 86.25;
        double out = Fit.manWeight(manWeight);
        Assert.assertEquals(exceptedWeight, out, 0);
    }

    @Test
    public void womanWeight() {

        int manWeight = 175;
        double exceptedWeight = 74.75;
        double out = Fit.womanWeight(manWeight);
        Assert.assertEquals(exceptedWeight, out, 0);
    }
}
