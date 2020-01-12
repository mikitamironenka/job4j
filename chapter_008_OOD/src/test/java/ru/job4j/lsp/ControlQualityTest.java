package ru.job4j.lsp;

import org.junit.Test;
import ru.job4j.lsp.models.*;

import javax.sql.rowset.BaseRowSet;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenFoodGetToShop() {
        Beer beer = new Beer("Beer", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-20"), 10.0, 10.0);
        Bread bread = new Bread("Bread", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-07"), 10.0, 20.0);
        Meet meet = new Meet("Meet", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-15"), 10.0, 50.0);
        Milk milk = new Milk("Milk", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-06"), 10.0, 10.0);
        Potato potato = new Potato("Potato", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-30"), 10.0, 35.0);

        ControlQuality controlQuality = new ControlQuality();
        controlQuality.setToday(LocalDate.parse("2020-01-07"));

        controlQuality.separateFood(beer);
        controlQuality.separateFood(bread);
        controlQuality.separateFood(meet);
        controlQuality.separateFood(milk);
        controlQuality.separateFood(potato);

        List<Food> shop = List.of(beer, meet);
        List<Food> warehouse = List.of(potato);
        List<Food> trash = List.of(bread, milk);

        assertThat(controlQuality.getShop().getFoods(), is(shop));
        assertThat(controlQuality.getWarehouse().getFoods(), is(warehouse));
        assertThat(controlQuality.getTrash().getFoods(), is(trash));
    }
}