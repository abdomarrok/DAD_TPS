package tp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tp3Main {

    static class T extends Thread {

        private static int add(int a, int b) {
            return a + b;
        }

        public static int sub(int a, int b) {
            return a - b;
        }

        public static int mult(int a, int b) {
            return a * b;
        }

        public static int div(int a, int b) {
            if (b != 0) {
                return a / b;
            } else {
                return 0;
            }
        }

        private final Socket s;
        private final String m;

        T(Socket s, String m) {
            this.s = s;
            this.m = m;
        }

        @Override
        public void run() {
            System.out.println("This code is running in a thread");
            PrintStream output;
            String t[] = new String[3];
            Integer result;
            
            try {
                //sanataize the message (ope,p,p2) to ope p p2 
                t = m.split(",");
                switch (t[0]) {
                    case "1":
                        result = add(Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                        break;
                    case "2":
                        result = sub(Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                        break;
                    case "3":
                        result = mult(Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                        break;
                    default:
                        result = div(Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                        break;

                }
                //write to client
                output = new PrintStream(s.getOutputStream());
                output.println(result.toString());
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(Tp3Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket sc = new ServerSocket(6000);
        Socket s;
        String m = "m";

        while (true) {
            s = sc.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //thread declaration 
            T t;
            m = input.readLine();
            //pass socket  s and message m
            t = new T(s, m);
            t.start();

        }
    }

}
