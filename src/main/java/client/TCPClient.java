package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

import model.Message;
import utils.JAXBUtils;

public class TCPClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: java TCPClient <server-ip> [<username>]");
            System.exit(1);
        }

        String serverIp = args[0];
        String username = (args.length == 2) ? args[1] : UUID.randomUUID().toString().substring(0, 5);

        Socket socket = new Socket(serverIp, 5555);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Connected to the server. Type your messages:");

        while (true) {
            String messageContent = System.console().readLine();

            if (messageContent.equals("q")) {
                System.out.println("Closing the client.");
                out.close();
                socket.close();
                break;
            }

            Message message = new Message(username, messageContent);
            String outputLine = JAXBUtils.marshal(message);
            out.println(outputLine);
        }
    }
}
