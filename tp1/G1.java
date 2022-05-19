package tp1;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
public class G1{
    static Semaphore s1 = null;  
    static Semaphore s2 = null;
    static float rand1;
     static float rand2;
     static float resultat;
     static float resultat1;

 class T extends Thread{
    @Override
    public void run() {
    System.out.println("This code is running in a thread");
    rand1= (float) Math.random();
     System.out.println("rand1"+rand1);
     s1.release();
 }
 }

class T2 extends Thread{
    @Override
    public void run() {
    System.out.println("This code is running in a thread");
    rand2= (float) Math.random();
    System.out.println("rand2"+rand2);
    s1.release();
 }
}
  class T3 extends Thread{
    @Override
    public void run() {
        try {
            s1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(G1.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("This code is running in a thread");
    resultat=rand1+rand2;
    System.out.println(resultat);
    s2.release();
 }}
  
    class T4 extends Thread{
    @Override
    public void run() {
        try {
            s2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(G1.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("This code is running in a thread");
    resultat1=resultat*resultat;
    System.out.println(resultat1);
 }}
    
 public static void main(String[] args) throws InterruptedException {
      
  
  s1 =new Semaphore(-1);
  
  s2 =new Semaphore(0);
    
    G1 g1 = new G1();
    
        
          T t1= g1.new T();
            t1.start();
            
          T2 t2= g1.new T2();
            t2.start();
           
          
        
          T3 t3= g1.new T3();
            t3.start();
          
            
          T4 t4= g1.new T4();
            t4.start();
            
          
            
            
            
        
         
   
 }
    
 }

    
   
 
  
    

