package threestonestest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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

    public ThreeStonesSession(InputStream in, OutputStream out) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("The address of this machine: " + address.getHostAddress());
        } catch (UnknownHostException e){
            System.out.println("Unable to determine this host's address");
        }

        this.playAgain = true;
        this.gameOver = false;
        this.in = in;
        this.out = out;
    }
    
    public void playSession(){
        ThreeStonesPacket packet = new ThreeStonesPacket(3,3,3,3,3);
        System.out.println("we are now playing in the session class");
        for(;;){
            
        }
    }
}
