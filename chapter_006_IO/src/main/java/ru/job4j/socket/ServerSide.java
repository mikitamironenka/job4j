package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerSide {

    private int port;
    private Socket socket;
    private List<String> messages;
    private String phrases;

    public ServerSide(int port, String phrases) throws IOException {
        this.port = port;
        this.phrases = phrases;
        this.messages = readMessagesFromFile(this.phrases);
        this.socket =  new ServerSocket(this.port).accept();
    }

    public ServerSide(Socket socket, String phrases) {
        this.socket = socket;
        this.phrases = phrases;
        this.messages = readMessagesFromFile(this.phrases);
    }

    private List<String> readMessagesFromFile(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getRandomPhrase() {
        Random random = new Random();
        return this.messages.get(random.nextInt(this.messages.size()));
    }

    public void init() throws IOException {
        String ask;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equalsIgnoreCase(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (("exit".equals(ask))) {
                break;
            } else {
                out.println(getRandomPhrase());
                out.println();
            }
        } while (!("exit".equals(ask)));
    }

//    public static void main(String[] args) throws IOException {

//        int port = 5000; //1025-65535
//        String file = "src/main/java/ru/job4j/socket/file.txt";
//        File sourceFile = new File(file);
//        String filePath = sourceFile.getAbsolutePath();
//        new ServerSide(port, filePath).init();

//        try {
//            ServerSocket serverSocket = new ServerSocket(port);
//            System.out.println("Ждем подключения к серверу");
//            Socket socket = serverSocket.accept();
//            System.out.println("Подключение состоялось");
//
//            InputStream socketInStr = socket.getInputStream();
//            OutputStream socketOutStr = socket.getOutputStream();
//
//            DataInputStream in = new DataInputStream(socketInStr);
//            DataOutputStream out = new DataOutputStream(socketOutStr);
//
//            String string = null;
//            while (true) {
//                string = in.readUTF();
//                System.out.println("Мы получили сообщение: " + string);
//                System.out.println("Отправляем обратно");
//                out.writeUTF(string);
//                out.flush();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//    }
}
