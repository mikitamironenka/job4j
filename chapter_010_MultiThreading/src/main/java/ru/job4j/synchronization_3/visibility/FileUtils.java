package ru.job4j.synchronization_3.visibility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    private File file;

    public FileUtils(File file) {
        this.file = file;
    }

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    //используем средства java nio. Синхронизация по самому объекту file.
    public String getContent() throws IOException {
        synchronized (file) {
            return new String(Files.readAllBytes(file.toPath()));
        }
    }
}
