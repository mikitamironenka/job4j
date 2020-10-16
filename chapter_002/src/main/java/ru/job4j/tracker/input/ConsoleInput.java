package ru.job4j.tracker.input;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.job4j.tracker.exception.MenuOutException;

import java.util.List;
import java.util.Scanner;

@Component
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
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("out of menu range");
        }
        return key;
    }
}
