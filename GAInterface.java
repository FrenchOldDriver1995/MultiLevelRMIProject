import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GAInterface extends Remote {

    public void  demandeAjouter(int numeroSite) throws RemoteException;
}