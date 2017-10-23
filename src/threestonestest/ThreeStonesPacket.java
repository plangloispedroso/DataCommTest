/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threestonestest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 *
 * @author Philippe
 */
public class ThreeStonesPacket {
    
    private byte[] packet = new byte[5];
    private Socket socket;
    private InputStream in;
    
    public ThreeStonesPacket(int a, int b, int c, int d, int e){
        try{
            packet[0] = (byte) a;
            packet[1] = (byte) b;
            packet[2] = (byte) c;
            packet[3] = (byte) d;
            packet[4] = (byte) e;
        }catch(Exception ex){
            System.out.println("Error Creating the packet");
        }
    }
    
    public byte[] receivePacket(InputStream input)throws IOException{
        in = input;
        in.read(packet);
        System.out.println("Receiving Packet");
        checkValues();
        //int totalBytesReceived = in.read(packet);
        //if(totalBytesReceived == 5){
        //    System.out.println("Packet received");
       //     return packet;
        //}
        //System.out.println("There was an error in receiving the packet");
        //return null;
        return packet;
    }
    
    public void sendPacket(OutputStream out)throws IOException{
        out.write(packet);
        System.out.println("Sending Packet");
        checkValues();
        //System.out.println("packet sent.");
        
    }
    
    private void checkValues(){
        System.out.println(packet[0] +", " +packet[1] +", " +packet[2] +", "
            +packet[3] +", " +packet[4]);
    }
        
}
