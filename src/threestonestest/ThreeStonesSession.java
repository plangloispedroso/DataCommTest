package threestonestest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Class that represents a game session between a client and a server.
 * 
 * @author Philippe
 */
public class ThreeStonesSession {
    
    private boolean playAgain;
    private boolean gameOver;
    private Socket clientSocket;
    private ThreeStonesPacket packet;
    private InputStream in;
    private OutputStream out;
    private Scanner reader;

    public ThreeStonesSession(InputStream in, OutputStream out) {
        this.playAgain = true;
        this.gameOver = false;
        this.in = in;
        this.out = out;
    }
    
    public void playSession()throws IOException{
        reader = new Scanner(System.in);
        int count = 0;
        ThreeStonesPacket packet = new ThreeStonesPacket(count, 0, 0, 0, 0);
        
        while(count < 10){
            packet.receivePacket(in);
            count++;
            packet = new ThreeStonesPacket(count, 0, 0, 0, 0);
            packet.sendPacket(out);
        }
    }
}
