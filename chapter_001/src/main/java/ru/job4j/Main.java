package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        System.out.println("RESULT VALID = " + tryCatch("3"));
//        System.out.println("RESULT INVALID = " + tryCatch("RRR"));

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        list.add(1,"E");
        list.add(3,"F");

        System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(i);
//            System.out.println(list.remove(i));
//            System.out.println(list.size());
//        }
//        System.out.println(list);

//2*)
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("a", "b", "c", "b", "d"));
        for (String str : list2) {
            if (str.equals("b")) {
                list.remove(str);
            }
        }

        System.out.println(list2);

    }

    private static Integer tryCatch(String str) {
        try {
            System.out.println("INSIDE TRY");
            return Integer.parseInt(str);
        } catch (Exception ex) {

            System.out.println("INSIDE CATCH");
            return -1;

        } finally {

            System.out.println("INSIDE FINALLY");
            return -2;
        }
    }
}
