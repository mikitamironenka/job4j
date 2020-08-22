package ru.job4j.threads_1.filedownloadtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class FileDownloadCallable implements Callable {

    private static final Logger LOG = LogManager.getLogger(FileDownloadCallable.class);
    private static int SPEED = 200;
    private String file;
    private static final String LOAD_COMPLETE = "Load completed.";

    public FileDownloadCallable(String file) {
        this.file = file;
    }

    @Override
    public String call() throws Exception {

        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("ussr.jpg")) {
            long startTime = System.currentTimeMillis();
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            double speedInKBps = 0.0D;
            int mDownloaded = 0;
            double timeInSec;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {

                fileOutputStream.write(dataBuffer, 0, bytesRead);
                timeInSec = (System.currentTimeMillis() - startTime) / 1000;
                mDownloaded = mDownloaded + bytesRead;
                try {
                    speedInKBps = (mDownloaded / timeInSec) / 1024D;
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                if (speedInKBps > SPEED) {
                    Thread.sleep((long) (1000 - timeInSec));
                }
            }
        } catch (IOException e) {
            LOG.error("load failed : {}", e.getMessage());
        }
        return LOAD_COMPLETE;
    }
}
