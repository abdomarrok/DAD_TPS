package tp_rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerRMi extends TP_RMI{   
    public ServerRMi(int id, int someinitial, String name, String prenom) throws RemoteException {
        super(id, someinitial, name, prenom);
    }
    
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            LocateRegistry.createRegistry(8888);
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRMi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServerRMi server = new ServerRMi(0, 0, "name", "prename");
        
            Naming.rebind("rmi://localhost:8888/compte", server);
        }
    }


