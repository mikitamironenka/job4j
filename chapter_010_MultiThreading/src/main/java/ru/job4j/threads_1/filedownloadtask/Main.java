package ru.job4j.threads_1.filedownloadtask;

public class Main {

    public static void main(String[] args) {
        String file = "https://i.artfile.me/wallpaper/13-10-2017/1920x1080/raznoe-simvoly-sssr--rossii-serp-molot-1247928.jpg";

        new FileLoader().loadFile(file);
    }
}
