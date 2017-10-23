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
        String clientAddress = "10.172.16.35"; //server machine
        ThreeStonesClient client = new ThreeStonesClient(clientAddress);
        client.makeConnection();
    }
}
