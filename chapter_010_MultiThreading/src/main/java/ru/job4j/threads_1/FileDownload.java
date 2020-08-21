package ru.job4j.threads_1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

//Нужно написать консольную программу аналог wget.
//Программа должна скачивать файл из сети с ограничением по скорости скачки.
//Например,
//java -jar wget.jar url 200
//wget (ссылка) (скорость в килобайтах в секунду)
//Для того, чтобы ограничить скорость скачивания, нужно проверять сколько байтов загрузиться за 1 секунду.
// Если объем больше, то нужно выставлять паузу.
//Пауза должна вычисляться, а не быть константой.

public class FileDownload {

    private static int SPEED = 200;

    public static void main(String[] args) throws Exception {

        String file = "https://i.artfile.me/wallpaper/13-10-2017/1920x1080/raznoe-simvoly-sssr--rossii-serp-molot-1247928.jpg";

        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("ussr.jpg")) {
            long startTime = System.currentTimeMillis();
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            double speedInKBps = 0.0D;
            int mDownloaded = 0;
            long timeInSec;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {

                fileOutputStream.write(dataBuffer, 0, bytesRead);
                timeInSec = (System.currentTimeMillis() - startTime) / 1000;
                mDownloaded = mDownloaded + bytesRead;
                try {
                    speedInKBps = (mDownloaded / timeInSec) / 1024D;
                    System.out.println(speedInKBps);
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                if (speedInKBps > SPEED) {
                    Thread.sleep(1000 - timeInSec);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
