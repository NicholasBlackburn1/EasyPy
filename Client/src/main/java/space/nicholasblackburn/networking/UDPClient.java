
*/
package space.nicholasblackburn.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import com.google.common.net.InetAddresses;

public class UDPClient {

    private final DatagramSocket udpSocket;

    public final InetAddress serveAddresses;
    public final int port;

    private final Scanner scanner;

    // This Function opens an connection to the python server
    private UDPClient(final String destinationAddr, final int port) throws IOException {
        this.serveAddresses = InetAddress.getByName(destinationAddr);
        this.port = port;
        udpSocket = new DatagramSocket(this.port);
        scanner = new Scanner(System.in);
    }

    public static void RunUdp(final String[] args) throws NumberFormatException, IOException {
        final UDPClient sender = new UDPClient(args[0], Integer.parseInt(args[1]));
        System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " --");
        sender.start();
    }

    private int start() throws IOException {
        String in;
        while (true) {
            in = scanner.nextLine();
            
            
			DatagramPacket p = new DatagramPacket(
                in.getBytes(), in.getBytes().length, serverAddress, port);
            
            this.udpSocket.send(p);                    
        }

}