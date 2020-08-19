package ru.job4j.dip;

import jdk.jfr.Description;
import org.junit.Test;
import ru.job4j.dip.ControlQuality;
import ru.job4j.dip.models.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Description("Сортируем продукты согласно сроку годности." +
        "Проверяем, что сортировка выполнена правильно." +
        "После этого меняем дату, достаём продукты и пересортируем их." +
        " Состав товаров в хранилищах меняется.")
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

        assertThat(controlQuality.getStorageList().get(1).getFood(), is(shop));
        assertThat(controlQuality.getStorageList().get(0).getFood(), is(warehouse));
        assertThat(controlQuality.getStorageList().get(2).getFood(), is(trash));

        //меняем дату и делаем ресорт, достаём продукты и пересортируем.
        controlQuality.setToday(LocalDate.parse("2020-01-15"));
        controlQuality.resort(List.of(controlQuality.getStorageList().get(0),
            controlQuality.getStorageList().get(1), controlQuality.getStorageList().get(2)));

        shop = List.of(potato, beer);
        trash = List.of(bread, milk, meet);

        assertThat(shop, containsInAnyOrder(controlQuality.getStorageList().get(1).getFood().toArray()));
        assertThat(trash, containsInAnyOrder(controlQuality.getStorageList().get(2).getFood().toArray()));
    }

}