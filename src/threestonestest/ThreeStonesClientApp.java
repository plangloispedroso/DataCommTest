package threestonestest;

import java.io.IOException;

/**
 * Class that is designed to start a client for a session of ThreeStones
 * 
 * @author Philippe
 */
public class ThreeStonesClientApp {
    
     public static void main(String[] args) throws IOException {
        // The ip address of the server(changes depending on machine)
        String clientAddress = "127.0.0.1"; 
        ThreeStonesClient client = new ThreeStonesClient(clientAddress);
        client.makeConnection();
    }
}
