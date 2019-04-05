import java.rmi.*;
 
public class SiteClient {
	//log to control all the msg of those sites

	public static void main (String[] args) {
		SiteInterface egsite;
		try {
  		        System.setSecurityManager(new RMISecurityManager());
			egsite = (SiteInterface)Naming.lookup("rmi://localhost/1234");
			
			String str = egsite.sendMsg(new Msg());
			System.out.println("Msgggg is :" + str);
 
			}catch (Exception e) {
				System.out.println("SiteClient exception: " + e);
				}
		}
}