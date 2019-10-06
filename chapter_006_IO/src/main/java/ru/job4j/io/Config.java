package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

//Примечания. Для работы с потоками ввода-вывода нужно использовать конструкцию try-with-resources.
//Задание.
//1. Реализуйте метод load по аналогии с методом toString. Метод load должен загружать пару ключ-значение в Map values.
//Метод load - должен считать все ключи в карту values.
// Важно в файле могут быть пустые строки и комментарии их нужно пропускать.
//2. Реализуйте метод value(String key) он должен возвращать значение ключа.
//3. Напишите тест ConfigTest.

public class Config {
    private final String path;
    private  Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public Map<String, String> getValues() {
        return this.values;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(line -> !line.contains("##") && !line.isEmpty())
                    .forEach(line -> this.values.putIfAbsent(line.split("=")[0], line.split("=")[1])
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

}
