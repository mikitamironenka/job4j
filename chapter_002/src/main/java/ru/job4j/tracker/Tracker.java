package ru.job4j.tracker;

//1. Реализовать класс Tracker. Класс трекер - это обертка над массивом;
//2. В классе должно быть поле private Item[] items = new Item[100];
//3. Данный класс используется, как хранилище для заявок;
//4. В нем должны быть следующие методы:
//добавление заявок - public Item add(Item item);
//редактирование заявок - public boolean replace(String id, Item item);
//удаление заявок - public boolean delete(String id);
//получение списка всех заявок - public Item[] findAll();
//получение списка по имени - public Item[] findByName(String key);
//получение заявки по id - public Item findById(String id);
//5. На все методы необходимо написать тесты.

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Tracker {

    /**
     * Array for storage items
     */
    private Item[] items = new Item[100];
    /**
     * Cell's position for new Item.
     */
    private int position = 0;

    /**
     * Generates unique key for new item.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Unique key.
     */
    private String generateId() {
        //Реализовать метод генерации.
        String result;
        int random = (int) (Math.random() * 1000 + 1);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        result = String.format("%04d %s", random, strDate);
        return result;
    }

    /**
     * Adds new item to storage
     * @param item new item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }


    /**
     * Gets Item by id from items
     * @param id item's id
     * @return item with the id
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Edit items
     * @param id item's id
     * @param item item
     * @return true or false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
            }
        }
        return result;
    }

    /**
     * Deletes item from array of items
     * @param id id of item to delete
     * @return boolean true or false
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                index = i;
                result = true;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                this.position--;
                break;
            }
        }
        return result;
    }

    /**
     * Gets all items
     * @return Item[]
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Gets Item by name
     * @param key - name of the item
     * @return Item
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

}
