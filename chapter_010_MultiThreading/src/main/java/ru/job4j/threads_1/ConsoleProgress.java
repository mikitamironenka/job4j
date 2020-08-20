package ru.job4j.threads_1;

//1. Создайте класс ru.job4j.concurrent.ConsoleProgress. Этот класс будет использован для вывода процесса загрузки в консоль.
//        Thread progress = new Thread(new ConsoleProgress());
//        progress.start();
//        Thread.sleep(1); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
//        progress.interrupt(); //
//2. Этот класс должен реализовывать интерфейс java.lang.Runnable.
//3. Внутри метода run нужно добавить цикл  с проверкой флага. Внутри цикла - сделать задержку в 500 мс.
//4. В тело цикла добавьте вывод в консоль.
//Loading ... |.
//Последний символ должен меняться: - \ | /.
//System.out.print("\r load: " + process[...]);
//Эти символы создадут эффект крутящегося шара.
//5. Добавьте в этот класс метод main с демонстрацией работы этого класса.

import lombok.SneakyThrows;

public class ConsoleProgress implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        int count = 0;
        char[] process = { '\\', '|', '/', '-' };

        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\r loading: " + process[count % 4]);
            Thread.sleep(500);
            count++;
        }
    }

    public static void main(String[] args) {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        try {
            Thread.sleep(10000); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress.interrupt(); //
    }

}
