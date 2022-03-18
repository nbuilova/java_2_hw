package lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("localhost", PORT);
            System.out.println("Подключено к серверу");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread t2 = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            t2.setDaemon(true);
            t2.start();

            while (true) {
                String str = inputStream.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Соединение с сервером завершено");
                    outputStream.writeUTF("/end");
                    break;
                } else {
                    System.out.println("Сервер: " + str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
