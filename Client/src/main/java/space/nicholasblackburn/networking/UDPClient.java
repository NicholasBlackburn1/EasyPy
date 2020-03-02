
package space.nicholasblackburn.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.google.common.net.InetAddresses;

import space.nicholasblackburn.Main;
import space.nicholasblackburn.gui.*;

public class UDPClient {

    public Controller controller = new Controller();

    private DatagramSocket udpSocket;
    private DatagramPacket DpSend;

    private Timer timer;
    private TimerTask task;

    public InetAddress Ip;
    public int port = 0;

    byte buf[] = null;

    public String CPU = "CPU";
    public String RAM = "RAM";
    public String DISK = "DISK";
    public String TEMP = "TEMP";

    private DataUpdate currentState;

    enum DataUpdate {
        CPU, RAM, DISK, Temp
    }

    // Updates Data Packets on network
    public DataUpdate State() {

        switch (currentState) {

            case CPU:
                buf = CPU.getBytes();

                currentState = DataUpdate.RAM;
                break;

            case RAM:
                buf = RAM.getBytes();

                currentState = DataUpdate.DISK;
                break;

            case DISK:
                buf = DISK.getBytes();

                currentState = DataUpdate.Temp;
                break;

            case Temp:
                buf = TEMP.getBytes();
                currentState = DataUpdate.CPU;
                break;

        }
        return currentState;
    }

    public void sendUdp() throws SocketException, UnknownHostException {

        Main.logger.info("starting to Send UDP Message");

        this.udpSocket = new DatagramSocket();
        this.Ip = controller.convertStringtoIP().toInetAddress();
        this.port = Integer.parseInt(controller.setPortNumber());

        this.DpSend = new DatagramPacket(buf, buf.length, this.Ip, this.port);

        // This Runs my Server Updater Every 5
        Main.logger.severe("Staring Timer Task ");
        this.task = new TimerTask() {

            @Override
            public void run() {
                if (State() == DataUpdate.CPU) {
                    buf = CPU.getBytes();

                    Main.logger.warning("CPU  Data Updated ");
                    Main.logger.info("CPU bytes" + CPU.getBytes());
                }
                if (State() == DataUpdate.RAM) {
                    buf = RAM.getBytes();

                    Main.logger.warning("RAM  Data Updated");
                    Main.logger.warning("RAM bytes" + RAM.getBytes());
                }
                if (State() == DataUpdate.DISK) {
                    buf = DISK.getBytes();

                    Main.logger.warning("DISK  Data Updated");
                    Main.logger.warning("DISK bytes" + DISK.getBytes());
                }
                if (State() == DataUpdate.Temp) {
                    buf = TEMP.getBytes();

                    Main.logger.warning("TEMP  Data Updated");
                    Main.logger.warning("TEMP bytes" + TEMP.getBytes());
                }

            }
        };

        while (true) {
            timer.schedule(task, 10);

            try {
                Main.logger.info("sending Request to Server");

                udpSocket.send(DpSend);
            } catch (IOException e) {

                e.printStackTrace();
                Main.logger.severe("SOCKET CANNOT CONNECT" + e.getMessage());
            }
        }

    }
}