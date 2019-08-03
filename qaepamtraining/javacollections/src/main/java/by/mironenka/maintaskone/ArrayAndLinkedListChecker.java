package by.mironenka.maintaskone;

import by.mironenka.maintaskone.model.Human;

import java.util.Iterator;
import java.util.List;

public class ArrayAndLinkedListChecker {

    public static void checkListOfHumans(List<Human> list) {

        while (list.size() > 1) {
            Iterator iterator = list.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
    }
}
