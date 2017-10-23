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
    
    public ThreeStonesClient(String address){
        this.address = address;
    }
    
    public void makeConnection() throws IOException{
       try{
           socket = new Socket(address, PORTNUMBER);
           System.out.println("Connected to server.");
           playSession();
       }catch(IOException e){
           System.out.println("There was a problem connectiong to the server");
       }
    }
    
    public void playSession()throws IOException{
        ThreeStonesPacket packet = new ThreeStonesPacket(2,2,1,2,2);
        System.out.println("Sending a packet");
        packet.sendPacket();
        int[] values = packet.getValues();
        System.out.println(values[0] +", " +values[1] +", " +values[2] +", "
            +values[3] +", " +values[4]);
        System.out.println("Receiving a packet");

    }
    
    public void makeMove()throws IOException{
        //packet.sendPacket();
    }
    
    public void receiveMove() throws IOException{
        //packet.receivePacket();
    }
    
    
}
