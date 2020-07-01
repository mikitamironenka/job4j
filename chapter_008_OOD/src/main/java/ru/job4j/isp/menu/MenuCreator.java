package ru.job4j.isp.menu;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.isp.entries.Entry;
import ru.job4j.isp.entries.MainEntry;
import ru.job4j.isp.entries.SubEntry;
import ru.job4j.isp.entries.SubSubEntry;
import ru.job4j.isp.menu.Menu;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuCreator {

    private Menu menu;

    public MenuCreator(Menu menu){
        this.menu = menu;
    }

    public List<Entry> createMenu() {
        this.menu.addEntry(new MainEntry("1"));
        this.menu.addEntry(new SubEntry("1.1"));
        this.menu.addEntry(new SubSubEntry("1.1.1"));
        this.menu.addEntry(new SubSubEntry("1.1.2"));
        this.menu.addEntry(new SubEntry("1.2"));
        this.menu.addEntry(new MainEntry("2"));
        return this.menu.getEntries();
    }
}
