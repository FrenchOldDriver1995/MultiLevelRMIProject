import java.rmi.*;
import java.rmi.server.*;   
 
public class ServerCentral {
	   public static void main (String[] argv) {
		   try {
			   System.setSecurityManager(new RMISecurityManager());
 
			   Site S = new Site();			   		   
			   Naming.rebind("rmi://localhost/1234", S);
 
			   System.out.println("Central__Server__is__ready.");
			   }catch (Exception e) {
				   System.out.println("Central Server failed: " + e);
				}
		   }
}