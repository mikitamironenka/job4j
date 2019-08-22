package ru.job4j.condition;

public class SqMax {

    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            }
        }
        if (second > third) {
            if (second > forth) {
                result = second;
            }
        }
        if (third > forth) {

            result = third;
        }
        return result;
//                int result = first;
//                if (first > second) {
//                    if (first > third) {
//                        if (first > forth) {
//                            result = first;
//                        }
//                    }
//                } else if (second > third) {
//                    if (second > forth) {
//                        result = second;
//                    }
//                } else if (third > forth) {
//                    result = third;
//                }
//                return result;
    }
}
