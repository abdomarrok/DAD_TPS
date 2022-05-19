package tp_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface compte_interface extends Remote{
    
    int criditie(int amount)throws RemoteException;
    int debitie(int amount)throws RemoteException;
    float lireSold()throws RemoteException;

    
    
}

