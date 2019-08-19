package ru.job4j.tracker.input;

import ru.job4j.tracker.exception.MenuOutException;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String ask(String s) {
        System.out.println(s);
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer;
    }

    @Override
    public int ask(String question, List<Integer> range) {

        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range){
            if (value == key){
                exist = true;
                break;
            }
        }
        if (exist){
            return key;
        }else{
            throw new MenuOutException("out of menu range");
        }
    }
}