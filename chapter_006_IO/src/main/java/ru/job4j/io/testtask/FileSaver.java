package ru.job4j.io.testtask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileSaver {

    public FileSaver() {

    }

    public List<String> saveFilesToDirectory(List<File> fileList, String output) {
        List<String> result = new ArrayList<>();
        try (PrintWriter out = new PrintWriter(new FileOutputStream(output))) {
            for (File file : fileList) {
                out.println(file.getName());
                result.add(file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
