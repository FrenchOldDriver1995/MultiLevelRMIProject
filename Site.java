import java.rmi.*;
import java.rmi.server.*;
 
public class Site extends UnicastRemoteObject implements SiteInterface {
      
      public Site () throws RemoteException {   }
 
      public String sendMsg(Msg msg) throws RemoteException {
		String str = msg.showMsg();
		return str;      
	}
 }