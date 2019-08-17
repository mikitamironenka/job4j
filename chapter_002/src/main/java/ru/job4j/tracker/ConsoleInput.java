package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String ask(String s) {
        System.out.println(s);
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer;
    }
}
