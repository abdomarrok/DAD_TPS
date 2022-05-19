package tptcp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String argv[]) throws Exception {
        try (Socket s = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream output = new PrintStream(s.getOutputStream());

            // read from user
            Scanner sc = new Scanner(System.in);
            String m = sc.nextLine();

            // write to server
            output.println(m);
            //read from the server
            String m1 = input.readLine();
            System.out.println("server sais " + m1);

        }

    }

}
