package ru.job4j.io;

import java.io.File;
import java.util.*;
//В этом задании нужно написать метод, который возвращает список всех файлов с конкретным расширением.
//String parent - это путь до каталога, с которого нужно осуществлять поиск.
//List<String> exts - это расширения файлов, которые мы хотим получить.
//В этой задаче нужно использовать методы.
//File file = new File(path);
//file.listFiles() - возвращает список всех каталогов и файлов находящихся в папке  file.
//file.isDirectory() - проверяет, что файл является директорией.
//file.getName() - возвращает имя файла с расширением.
//В этой задаче нужно написать тесты. Для тестов нужно создать временную структуру с файлами.
//Структуру нужно создавать в папке System.getProperty("java.io.tmpdir")
//Здесь нельзя использовать FileVisitor. Это задание на работу с деревом каталогов.

public class Search {
    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        File root = new File(parent);
        String fileExt;
        Queue<File> directories = new PriorityQueue<>();
        Collections.addAll(directories, root.listFiles());
        while (!directories.isEmpty()) {
            File current = directories.remove();
            if (current.isDirectory()) {
                Collections.addAll(directories, current.listFiles());
            } else {
                String curr = current.getName();
                if (curr.contains(".")) {
                    fileExt = curr.substring(curr.indexOf(".") + 1);
                    if (exts.contains(fileExt)) {
                        result.add(current);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> exts = List.of("java", "xml");
        Search search = new Search();
        List<File> res = search.files("C:\\projects\\job4j", exts);
        res.forEach(System.out :: println);
         res.forEach(o -> System.out.println(o.toString()));
    }
}
