package tp_rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class TP_RMI extends UnicastRemoteObject implements compte_interface{
    int id,someinitial;
    String name,prenom;
    public TP_RMI() throws RemoteException {}
    public TP_RMI(int id, int someinitial, String name, String prenom) throws RemoteException{
        this.id = id;
        this.someinitial = someinitial;
        this.name = name;
        this.prenom = prenom;
    }
  
    @Override
    public int criditie(int amount) throws RemoteException {
       someinitial=someinitial-amount;
       return someinitial;
    }


    
    @Override
    public int debitie(int amount) throws RemoteException {
        someinitial+= amount;
        return someinitial;
    }

    @Override
    public float lireSold() throws RemoteException {
       return (float)someinitial;
    }
    
}
