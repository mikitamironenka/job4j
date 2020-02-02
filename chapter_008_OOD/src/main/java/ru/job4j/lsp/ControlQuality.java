package ru.job4j.lsp;

//Класс должен перераспределять еду по хранилищам в зависимости от условий.
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
//3.2 Если срок годности от 25% до 75% направить в Shop
//3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
//3.4. Если срок годности вышел. Отправить продукт в мусорку.

import lombok.Getter;
import ru.job4j.lsp.models.Food;
import ru.job4j.lsp.storage.*;
import java.util.List;

@Getter
public class ControlQuality {

    private Warehouse warehouse = new Warehouse();
    private Shop shop = new Shop();
    private Trash trash = new Trash();

    private List<Storage> storages;
    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void separateFood(Food food) {
        for (Storage storage : this.storages) {
            if (storage.accept(food)) {
                storage.addFood(food);
                break;
            }
        }
    }

}
