package ru.job4j.lsp;

import org.junit.Test;
import ru.job4j.lsp.models.*;
import ru.job4j.lsp.storage.Shop;
import ru.job4j.lsp.storage.Storage;
import ru.job4j.lsp.storage.Trash;
import ru.job4j.lsp.storage.Warehouse;

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
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();

        List<Storage> storages = List.of(shop, warehouse, trash);

        ControlQuality controlQuality = new ControlQuality(storages);

        CalculateDate.today = LocalDate.parse("2020-01-07");

        controlQuality.separateFood(beer);
        controlQuality.separateFood(bread);
        controlQuality.separateFood(meet);
        controlQuality.separateFood(milk);
        controlQuality.separateFood(potato);

        List<Food> shops = List.of(beer, meet);
        List<Food> warehouses = List.of(potato);
        List<Food> trashs = List.of(bread, milk);

        assertThat(shop.getFoods(), is(shops));
        assertThat(warehouse.getFoods(), is(warehouses));
        assertThat(trash.getFoods(), is(trashs));
    }
}