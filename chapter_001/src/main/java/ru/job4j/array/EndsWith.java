package ru.job4j.array;

public class EndsWith {

    /**
     * Проверяет. что слово заканчивается суффиксом.
     * @param post суффикс.
     * @return если слово заканчивается суффиксом
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = wrd.length - pst.length; i < wrd.length; i++) {
            if (wrd[i] != pst[i - 1]) {
                result = false;
            }
        }
        return result;
    }
}
