package ru.job4j.io.testtask;

import java.util.HashMap;
import java.util.Map;

//Ключи
//-d - директория в которая начинать поиск.
//-n - имя файла, маска, либо регулярное выражение.
//-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
//-o - результат записать в файл.

public class Args {

    private final String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return this.args;
    }

    public String directory() {
        return this.args[1];
    }

    public String maskToFind() {
        String ext = this.args[3];
        return ext.substring(ext.indexOf(".") + 1);
    }

    public String fileToFind() {
        return this.args[3];
    }

    public String output() {
        return this.args[6];
    }

    public boolean isSearchByFullFileName() {
        boolean result = false;
        if (("-f").equalsIgnoreCase(this.args[4])) {
            result = true;
        }
        return result;
    }

}
