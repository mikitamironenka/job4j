package ru.job4j.musicplayer;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    private ClassicalMusic() {}

    public static ClassicalMusic getClassicalMusic() {
       return new ClassicalMusic();
    }

    @Override
    public void getMusic() {
        System.out.println("classical music");
    }

    public void doMyInit() {
        System.out.println("doing my classic initialisation");
    }

    public void doMyDestroy() {
        System.out.println("doing my classic destruction");
    }


}
