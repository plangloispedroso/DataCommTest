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

/**
 *
 * @author Philippe
 */
public class ThreeStonesPacket {
    
    private byte[] packet;
    Socket socket;
    
    public ThreeStonesPacket(int a, int b, int c, int d, int e, Socket socket){
        packet[0] = (byte) a;
        packet[1] = (byte) b;
        packet[2] = (byte) c;
        packet[3] = (byte) d;
        packet[4] = (byte) e;
        this.socket = socket;
    }
    
    public byte[] receivePacket()throws IOException{
        InputStream in = socket.getInputStream();
        int totalBytesReceived = in.read(packet);
        if(totalBytesReceived == 5){
            System.out.println("Packet received");
            return packet;
        }
        System.out.println("There was an error in receiving the packet");
        return null;
    }
    
    public void sendPacket()throws IOException{
        OutputStream out = socket.getOutputStream();
        out.write(packet);
        System.out.println("packet sent.");
    }
        
}
