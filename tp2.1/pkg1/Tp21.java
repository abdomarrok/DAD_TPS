
package tp2.1.pkg1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Tp21 {
    static Semaphore sema = null;
 
   static int mat[][]; 
   static  int n,m;
   static  int somme1=0;
   static  int somme2=0;
   static  int somme3=0;
   static  int somme4=0;
   static  int total=0;
  class T1 extends Thread{
    @Override
    public void run() {
       for(int i=0;i<n/4;i++) {
           for(int j=0;j<m;j++){
               somme1+=mat[i][j];
           }
       }
       System.out.println("somme1 "+somme1);
       sema.release();
            
 }
}
   class T2 extends Thread{
    @Override
    public void run() {
          for(int i=n/4;i<n/2;i++) {
           for(int j=0;j<m;j++){
               somme2+=mat[i][j];
           }
       }
       System.out.println("somme2 "+somme2);
       sema.release();
            
 }
       
 }

class T3 extends Thread{
    @Override
    public void run() {
        for(int i=n/2;i<(3*n)/4;i++) {
           for(int j=0;j<m;j++){
               somme3+=mat[i][j];
           }
       }
       System.out.println("somme3 "+somme3);
       sema.release();
            
 }
        
}
class T4 extends Thread{
    @Override
    public void run() {
          for(int i=(3*n)/4;i<n;i++) {
           for(int j=0;j<m;j++){
               somme4+=mat[i][j];
           }
       }
       System.out.println("somme4 "+somme4);
       sema.release();
            
 }
       
 }

class T5 extends Thread{
    @Override
    public void run() {
        try {
            sema.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tp21.class.getName()).log(Level.SEVERE, null, ex);
        }
       total=somme1+somme2+somme3+somme4;
       System.out.println("total"+total);
       
 }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          sema =new Semaphore(-2);
        Scanner sc =new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        mat= new int[n][m];
        
        for(int i=0;i<n;i++ ){
            for (int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }        
}    
        for(int i=0;i<n;i++ ){
            for (int j=0;j<m;j++){
               System.out.print( mat[i][j]);
            }     
            System.out.println();
}    
        
         Tp21 tp=new Tp21();
        
     T1 t1 = tp.new T1();
        t1.start();
     T2 t2 = tp.new T2();
        t2.start();
          T3 t3 = tp.new T3();
        t3.start();
          T4 t4 = tp.new T4();
        t4.start();
          T5 t5 = tp.new T5();
        t5.start();
    }
    
   
}
