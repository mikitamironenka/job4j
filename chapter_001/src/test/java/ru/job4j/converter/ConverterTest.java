package converter;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.converter.Converter;


public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {

        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);

    }

    @Test
    public void euroToRuble() {

        int in = 10;
        int expected = 700;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out);
    }


    @Test
    public void dollarToRuble() {

        int in = 10;
        int expected = 600;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out);
    }

}
