package ru.job4j.dip;

//Класс должен перераспределять еду по хранилищам в зависимости от условий.
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
//3.2 Если срок годности от 25% до 75% направить в Shop
//3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
//3.4. Если срок годности вышел. Отправить продукт в мусорку.

import lombok.Getter;
import ru.job4j.dip.models.Food;
import ru.job4j.dip.storage.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//Взять код из проекта Хранилище продуктов.
//    1. Необходимо добавить динамическое распределение продуктов.
//    2. В классе ControlQuality добавить метод resort();
//    он должен извлекать все продукты и перераспределять их заново.

@Getter
public class ControlQuality {

    private ZoneId defaultZoneId;
    private List<Storage> storageList;
    private LocalDate today;

    public ControlQuality() {
        storageList = new ArrayList<>();
        this.storageList.add(new Warehouse());
        this.storageList.add(new Shop());
        this.storageList.add(new Trash());
        this.defaultZoneId = ZoneId.systemDefault();
        this.today = new Date().toInstant().atZone(defaultZoneId).toLocalDate();
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public void separateFood(Food food) {
        int percentOfExpiration = calculatePercentOfDays(food);
        for (Storage storage : this.storageList) {
            if(storage.accept(food, percentOfExpiration)) {
                storage.addFood(food);
            }
        }
    }

    private int calculatePercentOfDays(Food food) {
        Period createToExpiration = Period.between(food.getCreateDate(), food.getExpirationDate());
        Period createToToday = Period.between(food.getCreateDate(), this.today);
        int expirationDays = createToExpiration.getDays();
        int passedDays = createToToday.getDays();
        return 100 * passedDays / expirationDays;
    }

    public void resort(List<Storage> storageList) {
        List<Food> foodList = storageList.stream()
            .flatMap(e -> e.getFood().stream())
            .collect(Collectors.toList());
        storageList.stream()
            .forEach(e -> e.getFood().clear());
        foodList.stream()
            .forEach(this::separateFood);
    }
}
