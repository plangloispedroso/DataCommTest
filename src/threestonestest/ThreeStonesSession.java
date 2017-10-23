package threestonestest;

import java.net.Socket;

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

    public ThreeStonesSession(Socket clientSocket) {
        System.out.println("You have started a session");
        this.playAgain = true;
        this.gameOver = false;
        this.clientSocket = clientSocket;
    }
    
    public void playSession(){
        System.out.println("let's play a game");
        while(playAgain){
            while(!gameOver){
                // game logic
                gameOver = true;
            }
            // Would you like to play again code
            playAgain = false;
        }
    }
}
