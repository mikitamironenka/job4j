package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void squareOne() {

        int p = 4, k = 1;
        int exceptedSquare = 1;

        int out = SqArea.square(p, k);

        Assert.assertEquals(exceptedSquare, out);
    }

    @Test
    public void squareTwo() {

        int p = 6, k = 2;
        int exceptedSquare = 2;

        int out = SqArea.square(p, k);

        Assert.assertEquals(exceptedSquare, out);
    }

}
