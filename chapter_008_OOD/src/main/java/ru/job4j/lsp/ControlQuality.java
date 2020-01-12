package ru.job4j.lsp;

//Класс должен перераспределять еду по хранилищам в зависимости от условий.
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
//3.2 Если срок годности от 25% до 75% направить в Shop
//3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
//3.4. Если срок годности вышел. Отправить продукт в мусорку.

import lombok.Data;
import lombok.Getter;
import ru.job4j.lsp.models.Beer;
import ru.job4j.lsp.models.Food;
import ru.job4j.lsp.storage.*;

import java.time.*;
import java.util.Date;

@Getter
public class ControlQuality {

    private Context context;
    private ZoneId defaultZoneId;
    private Warehouse warehouse = new Warehouse();
    private Shop shop = new Shop();
    private Trash trash = new Trash();

    private LocalDate today;

    public ControlQuality() {
        this.context = new Context();
        this.defaultZoneId = ZoneId.systemDefault();
        this.today = new Date().toInstant().atZone(defaultZoneId).toLocalDate();
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public void separateFood(Food food) {
        int percentOfExpiration = calculatePercentOfDays(food);
        System.out.println(percentOfExpiration);
        if (percentOfExpiration < 25) {
            this.context.setStorage(warehouse);
        } else if (25 < percentOfExpiration && percentOfExpiration < 75) {
            this.context.setStorage(shop);
        } else if (percentOfExpiration > 75 && percentOfExpiration < 100) {
            food.setDiscount(30);
            this.context.setStorage(shop);
        } else if (percentOfExpiration >= 100) {
            this.context.setStorage(trash);
        }
        this.context.addFoodToStorage(food);
    }

    private int calculatePercentOfDays(Food food) {
        Period createToExpiration = Period.between(food.getCreateDate(), food.getExpirationDate());
        Period createToToday = Period.between(food.getCreateDate(), this.today);
        int expirationDays = createToExpiration.getDays();
        int passedDays = createToToday.getDays();
        return 100 * passedDays / expirationDays;
    }
}
