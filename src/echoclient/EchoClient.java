package echoclient;

import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) throws IOException, InterruptedException, NullPointerException {

        Socket s = new Socket("127.0.0.1", 6666);
        String toServer;
        BufferedReader sock_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter sock_out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        BufferedReader std_in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter std_out = new PrintWriter(new OutputStreamWriter(System.out), true);
        
        while (true) {
            sock_out.println(std_in.readLine());
            //std_out.println(sock_in.readLine());
            toServer = sock_in.readLine();
            System.out.println(toServer);
            if(toServer.equalsIgnoreCase("Terminato")){
                s.close();
                System.exit(0);
            }
        }
    }
}
