package ru.job4j.tracker.input;

import ru.job4j.tracker.exception.MenuOutException;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(MenuOutException moe) {
                System.out.println("Please, select key from menu");
            } catch(NumberFormatException nfe) {
                System.out.println("Please, enter validate data again");
            }
        } while(invalid);
        return value;
    }
}
