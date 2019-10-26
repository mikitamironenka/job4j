package ru.job4j.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {

    private Socket socket;
    private String ip;
    private int port;

    public ClientSide(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void init() throws IOException {
        Socket socket = new Socket(InetAddress.getByName(this.ip), this.port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String inString = null;
        String outString = null;
        do {
            outString = console.nextLine();
            out.println(outString);
            inString = in.readLine();
            while (!inString.isEmpty()) {
                System.out.println(inString);
            }
        } while (!("exit").equalsIgnoreCase(outString));
    }

    public static void main(String[] args) throws IOException {

        int serverPort = 5000;
        String interAddress = "127.0.0.1";

        new ClientSide(interAddress, serverPort).init();

//        try {
//            InetAddress inetAddress = InetAddress.getByName(interAddress);
//            System.out.println("Подключаемся к серверу: " +serverPort);
//            Socket socket = new Socket(inetAddress, serverPort);
//
//            InputStream socketInStr = socket.getInputStream();
//            OutputStream socketOutStr = socket.getOutputStream();
//
//            DataInputStream in = new DataInputStream(socketInStr);
//            DataOutputStream out = new DataOutputStream(socketOutStr);
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String string = null;
//            System.out.println("Введите фразу для передачи серверу: ");
//
//            while (true) {
//                string = reader.readLine();
//                out.writeUTF(string);
//                out.flush();
//                string = in.readUTF();
//                System.out.println("Сервер прислал ответ: " + string);
//                System.out.println("Введите фразу для отправки на сервер: ");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
