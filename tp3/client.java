
package tp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class client {
    public static void main(String argv[]) throws Exception {
       
        try (Socket s = new Socket("localhost", 6000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream output = new PrintStream(s.getOutputStream());
             Scanner sc = new Scanner(System.in);
            System.out.println("entrer la fonction : \n "
                    + "\t1 : add\n"
                    + "\t2 : sub\n"
                    + "\t3 : mult\n"
                    + "\t4 : div\n");
           System.out.println("enter your statement like this  \t oper ,parm1 , parm2 \n");
            
           
            String m = sc.nextLine();
            // write to server
            output.println(m);
            //read from the server
            String m1 = input.readLine();
            System.out.println("server sais " + m1);

        }

    }
}
