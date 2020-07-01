package ru.job4j.lsp;

import ru.job4j.lsp.models.Food;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CalculateDate {

    private static ZoneId defaultZoneId = ZoneId.systemDefault();;
    public static LocalDate today = new Date().toInstant().atZone(defaultZoneId).toLocalDate();

    public static int calculatePercentOfDays(Food food) {
        Period createToExpiration = Period.between(food.getCreateDate(), food.getExpirationDate());
        Period createToToday = Period.between(food.getCreateDate(), today);
        int expirationDays = createToExpiration.getDays();
        int passedDays = createToToday.getDays();
        return 100 * passedDays / expirationDays;
    }
}
