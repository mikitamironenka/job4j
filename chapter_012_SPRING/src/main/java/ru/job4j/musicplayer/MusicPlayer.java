package ru.job4j.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicPlayer {

    private List<Music> musicList;

    private ClassicalMusic classicalMusic;
    private DoomMusic doomMusic;

    private Music music;
    private String name;
    private int volume;

    public MusicPlayer() {
    }

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, DoomMusic doomMusic) {
        this.classicalMusic = classicalMusic;
        this.doomMusic = doomMusic;
    }

//    public Music getMusic() {
//        return classicalMusic;
//    }

//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

//    public void playMusic() {
//        for(Music music : this.musicList) {
//            music.getMusic();
//        }
//    }

    public void playMusic() {
        this.classicalMusic.getMusic();
        this.doomMusic.getMusic();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void doMyInit() {
        System.out.println("doing my initialisation");
    }

    public void doMyDestroy() {
        System.out.println("doing my destroy");
    }
}
