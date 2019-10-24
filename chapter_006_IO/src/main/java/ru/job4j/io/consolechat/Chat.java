package ru.job4j.io.consolechat;

//Создать программу 'Консольный чат'. Пользователь вводит слово-фразу, программа берет случайную фразу
// из текстового файла и выводит в ответ. Программа замолкает если пользователь вводит слово «стоп»,
// при этом он может продолжать отправлять сообщения в чат. Если пользователь вводит слово «продолжить»,
// программа снова начинает отвечать. При вводе слова «закончить» программа прекращает работу.
// Запись диалога включая, слова-команды стоп/продолжить/закончить записать в текстовый лог.
//Так делать не надо:
// while (true) { - консольный чат должен явно выходить из цикла, не делайте вечный цикл.

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chat {

    private static final String STOP = "Стоп";
    private static final String CONTINUED = "Продолжить";
    private static final String FINISH = "Закончить";

    private String log;
    private String phrases;
    private List<String> messages;
    private boolean exit = false;
    private boolean continued = true;

    public Chat() { }

    public Chat(String log, String phrases) throws IOException {
        this.log = log;
        this.phrases = phrases;
        this.messages = readMessagesFromFile(this.phrases);
    }

    public List<String> readMessagesFromFile(String file) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    public String getRandomPhrase() {
        Random random = new Random();
        return this.messages.get(random.nextInt(this.messages.size()));
    }

    /**
     *
     */
    public void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fr = new FileWriter(this.log)) {
            while (!exit) {
                recordChat(reader, fr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void recordChat(BufferedReader reader, FileWriter writer) throws IOException {

        String client;
        String bot;
        client = reader.readLine();
        writer.write("Client : " + client + System.lineSeparator());
        checkAnswer(client);
        if (continued) {
            bot = getRandomPhrase();
            writer.write("Bot    : " + bot + System.lineSeparator());
            System.out.println(bot + System.lineSeparator());
        }
    }


    private void checkAnswer(String answer) {

        if (Chat.CONTINUED.equalsIgnoreCase(answer)) {
            this.continued = true;
        } else if (Chat.STOP.equalsIgnoreCase(answer)) {
            this.continued = false;
        } else if (Chat.FINISH.equalsIgnoreCase(answer)) {
            this.exit = true;
        }
    }
    public static void main(String[] args) throws IOException {

        String file = "C:/projects/job4j/chapter_006_IO/src/main/java/ru/job4j/io/consolechat/file.txt";
        String log = "C:/projects/job4j/chapter_006_IO/src/main/java/ru/job4j/io/consolechat/log.txt";
        Chat chat = new Chat(log, file);
        chat.start();
    }
}
