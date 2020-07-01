package ru.job4j.isp.menu;


import lombok.Data;
import ru.job4j.isp.entries.Entry;
import ru.job4j.isp.items.Item;
import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {

    private List<Entry> entries =  new ArrayList<>();

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public void removeEntry(Entry entry) {
        this.entries.remove(entry);
    }

    public void showMenu() {
        for (Entry entry : this.entries) {
            entry.show();
        }
        System.out.println("Choose the task or type 'exit' for exit");
    }
}
