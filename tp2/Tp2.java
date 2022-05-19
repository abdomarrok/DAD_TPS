
package tp2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tp2 {
    static Semaphore sema = null;  
   
static int x=100;
int a[][]={{1,3,4,10},{2,4,3,1},{3,4,9,5},{3,4,9,5}};  
class T extends Thread{
    @Override
    public void run() {
        try {
            sema.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tp2.class.getName()).log(Level.SEVERE, null, ex);
        }
    x=x+20;
    System.out.println("x t1="+x);
    sema.release();
 }
 }

class T2 extends Thread{
    @Override
    public void run() {
        try {
            sema.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tp2.class.getName()).log(Level.SEVERE, null, ex);
        }
        x=x-100;
        System.out.println("x t2="+x);
        sema.release();
 }
}
    public static void main(String[] args) {
        sema =new Semaphore(1);
        Tp2 objet = new Tp2();
        T t1 = objet.new T();
        
        T2 t2 = objet.new T2();
        t1.start();
        t2.start();
        try {
            sema.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tp2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("from main="+x);
        sema.release();
        
       
        
        
    }
    
}
