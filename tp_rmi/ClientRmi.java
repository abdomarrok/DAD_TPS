package tp_rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class ClientRmi {
      
    public static void main(String[] args) throws RemoteException, MalformedURLException , NotBoundException{
        compte_interface stub;
        stub = (compte_interface) Naming.lookup("rmi://localhost:8888/compte");
        
        System.out.println("credite"+stub.criditie(50));
        System.out.println("debitie"+ stub.debitie(30));
        System.out.println("lire sold"+stub.lireSold());
       
    }
  
}
