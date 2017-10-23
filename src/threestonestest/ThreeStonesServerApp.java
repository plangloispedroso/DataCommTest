package threestonestest;

import java.io.IOException;

/**
 * A class that is used to create a ThreeStonesServer object and start running 
 * the server.
 * 
 * @author Philippe
 */
public class ThreeStonesServerApp {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        ThreeStonesServer server = new ThreeStonesServer();
        server.runServer();
    }
    
}
