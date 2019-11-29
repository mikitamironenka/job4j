package ru.job4j.musicplayer;

import org.springframework.stereotype.Component;

@Component
public class Computer {

    private int id;
    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        this.id = 1;
    }

    public void playMusicPlayer() {
        System.out.println("play from computer. Running music player.");
        this.musicPlayer.playMusic();
    }
}
