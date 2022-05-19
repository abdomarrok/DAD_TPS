package tptcp;
ort java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    static Integer counter = 0;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        ServerSocket sc = new ServerSocket(5000);
        Socket s;
        String m;
        while (true) {
            // assign server socket to a normal socket
            s = sc.accept();
            counter += 1;
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream output = new PrintStream(s.getOutputStream());

            // read from the client 
            m = input.readLine();

            System.out.println("client " + counter.toString() + ": sais" + m);
            // write to the client
            output.println("you are welcome");
            s.close();
        }
    }

}
