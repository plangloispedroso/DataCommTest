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
        ThreeStonesPacket packet = new ThreeStonesPacket(1, 1, 1, 1, 1);
        reader = new Scanner(System.in);
        int response = reader.nextInt();
        if(response == 0){
            byte[] receivedBytes = packet.receivePacket(in);
        } else {
            packet.sendPacket(out);
        }

    }
    
    public void makeMove()throws IOException{
        //packet.sendPacket();
    }
    
    public void receiveMove() throws IOException{
        //packet.receivePacket();
    }
    
    
}
