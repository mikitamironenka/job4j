package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Метод main - записывает текст в файл "unavailable.csv"
//Задание.
//1. Реализуйте метод unavailable.
//source - имя файла лога
//target - имя файла после анализа.
//2. Метод unavailable() должен находить диапазоны, когда сервер не работал.
//Сервер не работал. если status = 400 или 500.
//Диапазон считается последовательность статусов 400 и 500
//Например:
//200 10:56:01          200 10:59:01
//500 10:57:01          500 11:01:02
//400 10:58:01          200 11:02:02
//тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02
//Начальное время - это время когда статус 400 или 500. конечное время это когда статус меняется с 400 или 500 на 200 300.
//3. Результат анализа нужно записать в файл target.
//Формат файла
//начала периода;конец периода;
//4. Записать тесты.

public class Analizy {

    private final String lineSeparator = System.lineSeparator();
    private List<String> list;

    public Analizy() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return this.list;
    }

    public void unavailable(String source, String target) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String st;
                boolean isAvailable = true;
                String code;
                String time;
                while ((st = reader.readLine()) != null) {
                    code = st.substring(0, st.indexOf(" "));
                    time = st.substring(st.indexOf(" ") + 1);
                    if ((code.startsWith("4") || code.startsWith("5")) && isAvailable) {
                        isAvailable = false;
                        this.list.add(time + "-");
                    } else if (!isAvailable && !((code.startsWith("4") || code.startsWith("5")))) {
                        isAvailable = true;
                        this.list.add(time + lineSeparator);
                    }
                }
            }

        writeToFile(this.list, target);
    }

    private void writeToFile(List<String> list, String fileName) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName))) {
            for (String string : list) {
                out.print(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
