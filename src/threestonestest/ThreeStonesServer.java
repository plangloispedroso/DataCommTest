/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threestonestest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class that handles all the tasks that a server will perform.
 * 
 * @author Philippe
 */
public class ThreeStonesServer {
    
    private static final int PORTNUMBER = 50000;
    ServerSocket servSocket;
    
    /**
     * Default constructor.
     */
    public ThreeStonesServer(){
        try{
            servSocket = new ServerSocket(PORTNUMBER);
        }catch(IOException e){
            System.out.println("There was a problem starting the server");
        }
    }
    
    /**
     * Method that will keep the server up and running. The server will listen
     * listen for clients that wish to make a connection. Once connected a session
     * is made and the game begins. When the client closes the connection, the
     * server will return to listening for new clients.
     * 
     * @throws IOException 
     */
    public void runServer()throws IOException{
        for(;;){
            System.out.println("Now looking for clients.");
            // try with resources will automatically close the socket when finished.
            Socket clientSocket = servSocket.accept();
            System.out.println("Handling client at: " 
                +clientSocket.getInetAddress().getHostAddress()
                +" on port: " +clientSocket.getLocalPort());
            // Create a new session with client
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            ThreeStonesSession session = new ThreeStonesSession(in, out);
            // Start playing with the client
            session.playSession();
            servSocket.close();
            System.out.println("Client disconnected");
        }
    }
}
