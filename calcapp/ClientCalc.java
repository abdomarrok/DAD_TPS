
package calcapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class ClientCalc {
    
    
    public static void main(String argv[]) throws Exception {
         String []t =new String[5];
         String t2 = "";
        try (Socket s = new Socket("localhost", 8000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream output = new PrintStream(s.getOutputStream());

            // read from user
            
            /*System.out.println("entrer la fonction : \n "
                    + "\t1 : add\n"
                    + "\t2 : sub\n"
                    + "\t3 : mult\n"
                    + "\t4 : div\n");*/
            
            
            System.out.println("enter your statement ( parm1 operation parm2 )\n");
            
            Scanner sc = new Scanner(System.in);
            String m = sc.nextLine();
              
            if (m.contains("+")){
               t = m.split("");
            }
            if (m.contains("-")){
               t = m.split("-");
            }
            if (m.contains("*")){
               t = m.split("*");
            }
            if (m.contains("/")){
               t = m.split("/");
            }
           System.out.println(t[0]);
           System.out.println(t[1]);
           System.out.println(t[2]);
            
            
           /*
            Scanner sc = new Scanner(System.in);
            String m = sc.nextLine();
            m=m+",";
            System.out.println("entrer le promier paramatere : ");
             m += sc.nextLine();
             m=m+",";
             System.out.println("entrer le deuxieme paramatere :");
             m += sc.nextLine();

          t=m.split(",");
            */
            
           switch(t[1]){
                 
                case "+":
                   t2="1"+","+(String)t[0]+","+(String)t[2];
                   break;
                case "-":
                   t2="2"+","+(String)t[0]+","+(String)t[2];
                   break;
                case "*":
                   t2="3"+","+(String)t[0]+","+(String)t[2];
                   break;
                case "/":
                   t2="4"+","+(String)t[0]+","+(String)t[2];
                   break;
                default:
                    break;
                   
            }
            
            // write to server
            output.println(t2);
            //read from the server
            String m1 = input.readLine();
            System.out.println("server sais " + m1);

        }

    }
}
