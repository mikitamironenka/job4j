package ru.job4j.synchronization_3.visibility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ParseFileCorrect {

    private File file;

    public ParseFileCorrect(File file) {
        this.file = file;
    }

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return new String(Files.readAllBytes(file.toPath())).replaceAll("\\P{InBasic_Latin}", "");
    }

    public void saveContent(String content) throws IOException {
        synchronized (file) {
            Files.write(file.toPath(), content.getBytes(), StandardOpenOption.WRITE);
        }
    }
}
