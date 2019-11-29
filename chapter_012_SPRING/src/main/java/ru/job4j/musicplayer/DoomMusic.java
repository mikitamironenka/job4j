package ru.job4j.musicplayer;

//для создания бина используется аннотация Component, в скобках можно указать id бина,
//если не указывать, то будет создан id по умолчанию = названию класса с маленькой буквы.

import org.springframework.stereotype.Component;

@Component
public class DoomMusic implements Music {
    @Override
    public void getMusic() {
        System.out.println("DOOOOOOOOOoooom music!");
    }
}
