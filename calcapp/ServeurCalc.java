
package calcapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pc
 */
public class ServeurCalc {
    

    /**
     * @param args the command line arguments
     */
    
     public  static int add(int a,int b){
         return a+b;
     }
     public static int sub(int a,int b){
         return a-b;
     }
     public static int  mult(int a,int b){
         return a*b;
     }
     public static int div(int a, int b) {
         if(b!=0)
        return a/b; 
         else return 0;
    }

     
    public static void main(String[] args) throws IOException {
        ServerSocket sc = new ServerSocket(8000);
        Socket s;
        String m;
        String []t =new String[5];
         Integer  result=0;
        
        while (true) {
            // assign server socket to a normal socket
            s = sc.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream output = new PrintStream(s.getOutputStream());

            // read from the client 
            m = input.readLine();
           
            
            t=m.split(",");
            System.out.println("function :" + t[0]+"parm1"
                    + t[1] +"parm2"
                            + t[2]);
            
            
            // write to the client
           
            switch (t[0]){
                case "1":
                   result=add(Integer.parseInt(t[1]),Integer.parseInt(t[2]));
                   break;
                case "2":
                  result=sub(Integer.parseInt(t[1]),Integer.parseInt(t[2]));
                    break;
                    case "3":
                 result=mult(Integer.parseInt(t[1]),Integer.parseInt(t[2]));
                    break;
                    default:      
                 result=div(Integer.parseInt(t[1]),Integer.parseInt(t[2])); 
                     break;
                    
                      
            }

            
            output.println(result.toString());
            s.close();
        }
        
    }

        
}
