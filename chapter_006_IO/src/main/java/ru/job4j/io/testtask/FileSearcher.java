package ru.job4j.io.testtask;

//1. Создать программу для поиска файла.
//2. Программа должна искать данные в заданном каталоге и подкаталогах.
//3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
//4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
//Ключи
//-d - директория, в которой начинать поиск.
//-n - имя файла, маска, либо регулярное выражение.
//-m - искать по максе, либо -f - полное совпадение имени. -r регулярное выражение.
//-o - результат записать в файл.
//5. Программа должна записывать результат в файл.
//6. В программе должна быть валидация ключей и подсказка.

import java.io.File;
import java.util.*;

public class FileSearcher {

    private String fileName;
    private String mask;
    private String directory;

    private Args args;

    public FileSearcher(Args args) {
        this.args = args;
        this.directory = args.directory();
    }

    public List<File> search() {
        List<File> result;
        if (this.args.isSearchByFullFileName()) {
            this.fileName = this.args.fileToFind();
            result = findFileByName(this.directory, this.fileName);
        } else {
            this.mask = this.args.maskToFind();
            result = findFileByMask(this.directory, this.mask);
        }
        return result;
    }

    private List<File> findFileByName(String directory, String fileName) {
        List<File> result = new ArrayList<>();
        File root = new File(directory);
        Queue<File> directories = new PriorityQueue<>();
        Collections.addAll(directories, root.listFiles());
        while (!directories.isEmpty()) {
            File current = directories.remove();
            if (current.isDirectory()) {
                Collections.addAll(directories, current.listFiles());
            } else {
                String curr = current.getName();
                if (fileName.equals(curr)) {
                    result.add(current);
                }
            }
        }
        return result;
    }

    private List<File> findFileByMask(String directory, String fileMask) {
        List<File> result = new ArrayList<>();
        File root = new File(directory);
        String fileExt;
        Queue<File> directories = new PriorityQueue<>();
        Collections.addAll(directories, root.listFiles());
        while (!directories.isEmpty()) {
            File current = directories.remove();
            if (current.isDirectory() && current != null) {
                Collections.addAll(directories, current.listFiles());
            } else {
                String curr = current.getName();
                if (curr.contains(".")) {
                    fileExt = curr.substring(curr.indexOf(".") + 1);
                    if (fileMask.equals(fileExt)) {
                        result.add(current);
                    }
                }
            }
        }
        return result;
    }


}
