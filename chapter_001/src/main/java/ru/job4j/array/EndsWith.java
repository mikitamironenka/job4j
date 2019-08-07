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
        int j = pst.length - 1;
        for (int i = wrd.length - 1; i > wrd.length - pst.length - 1; i--) {
            if (wrd[i] != pst[j]) {
                result = false;
                break;
            }
            j--;
        }
        return result;
    }
}
