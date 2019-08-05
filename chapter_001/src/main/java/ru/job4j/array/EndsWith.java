package ru.job4j.array;

public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        for(int i = wrd.length - pst.length; i < wrd.length ; i++) {
            if(wrd[i] != pst[i - pst.length - 1]) {
                result = false;
            }
        }
        return result;
    }
}
