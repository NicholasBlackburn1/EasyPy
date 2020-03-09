package space.nicholasblackburn.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import space.nicholasblackburn.Main;

public class Client {

    private Socket socket;
    private byte data;

    private OutputStream output;
    private InputStream input;

    // Client Init Function
    public Client(String Ip, int port) {

        try {
            socket = new Socket(Ip, port);

        } catch (UnknownHostException e) {
            Main.logger.info("[socket]" + e);
        } catch (IOException e) {
            Main.logger.info("[socket]" + e);

        }

        Main.logger.info("Starting Tcp client ");

    }

}