package ru.job4j.referenciestypes;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Создать структуру данных типа кеш.
// Кеш должен быть абстрактный. То есть необходимо, чтобы можно было задать ключ получения
// объекта кеша и в случае если его нет в памяти, задать поведение загрузки этого объекта в кеш.
//Создать программу эмулирующее поведение данного кеша.
//Программа должна считывать текстовые файлы из системы и выдавать текст при запросе имени файла.
//Если в кеше файла нет. Кеш должен загрузить себе данные.
//По умолчанию в кеше нет ни одного файла. Текстовые файл должны лежать в одной директории.
//Пример. Names.txt, Address.txt - файлы в системе.
//При запросе по ключу Names.txt - кеш должен вернуть содержимое файла Names.txt.

public class Cache {

    private String filePath;
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    public Cache(String filePath) {
        this.filePath = filePath;
    }

    public void addToCache(String filename) {
        Path path = Paths.get(String.format("%s/%s", this.filePath, filename));
        StringBuilder sb = new StringBuilder();
        try {
            List<String> content = Files.readAllLines(path);
            for (String string : content) {
                sb.append(string).append(System.getProperty("line.separator"));
            }
            this.cache.put(filename, new SoftReference<>(sb.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileContent(String filename) {
        if (this.cache.get(filename) != null) {
            return this.cache.get(filename).get();
        } else {
            this.addToCache(filename);
            return this.cache.get(filename).get();
        }
    }
}
