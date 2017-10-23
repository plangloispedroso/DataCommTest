package threestonestest;

import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream
import java.util.Scanner;

/**
 *
 * @author Philippe
 */
public class ThreeStonesClient {
    
    public static final int PORTNUMBER = 50000;
    private String address;
    private Socket socket;
    private ThreeStonesPacket packet;
    private Scanner reader;
    private boolean playerControl = true;
    private boolean gameInProgress = false;
    private InputStream in;
    private OutputStream out;
    
    public ThreeStonesClient(String address){
        this.address = address;
    }
    
    public void makeConnection() throws IOException{
       try{
           System.out.println("Trying to make connection");
           socket = new Socket(address, PORTNUMBER);
           in = socket.getInputStream();
           out = socket.getOutputStream();
           System.out.println("Connected to server.");
           playSession();
       }catch(IOException e){
           System.out.println("There was a problem connectiong to the server");
       }
    }
    
    public void playSession()throws IOException{
        reader = new Scanner(System.in);
        System.out.println("Starting the game");
        packet = new ThreeStonesPacket(1, 0, 0, 0, 0);
        for(;;){
            makeMove();
            receiveMove();
            System.out.println("Make your next move");
            int choice = reader.nextInt();
            packet = new ThreeStonesPacket(choice, 0, 0, 0, 0);
        }
    }
    
    public void makeMove()throws IOException{
        packet.sendPacket(out);
    }
    
    public void receiveMove() throws IOException{
        packet.receivePacket(in);
    }
    
    
}
