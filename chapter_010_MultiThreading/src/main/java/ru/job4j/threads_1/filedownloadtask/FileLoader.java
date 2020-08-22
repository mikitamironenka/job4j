package ru.job4j.threads_1.filedownloadtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileLoader {

    public void loadFile(String file) {
        Callable loader = new FileDownloadCallable(file);
        FutureTask task = new FutureTask(loader);
        Thread t = new Thread(task);
        t.start();
    }
}
