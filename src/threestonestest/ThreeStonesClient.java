package threestonestest;

import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

/**
 *
 * @author Philippe
 */
public class ThreeStonesClient {
    
    public static final int PORTNUMBER = 50000;
    private String address;
    private Socket socket;
    private ThreeStonesPacket packet;
    
    public ThreeStonesClient(String address){
        this.address = address;
    }
    
    public void makeConnection() throws IOException{
       try{
           socket = new Socket(address, PORTNUMBER);
           System.out.println("Connected to server.");
           packet = new ThreeStonesPacket(0,0,0,0,0, socket);
       }catch(IOException e){
           System.out.println("There was a problem connectiong to the server");
       }
    }
    
    public void playSession(){
        
    }
    
    public void makeMove()throws IOException{
        packet.sendPacket();
    }
    
    public void receiveMove() throws IOException{
        packet.receivePacket();
        
    }
    
    
}
