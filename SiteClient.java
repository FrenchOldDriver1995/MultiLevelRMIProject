import java.rmi.*;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
//ça mélange ProgrammeSite

public class SiteClient {
	//public static boolean veutentrer = false;
	//log to control all the msg of those sites
	public static ArrayList<SiteInterface> siteList = new ArrayList<>();

	public static void main (String[] args) {

		GAInterface ga = null;
		int num_site = Integer.parseInt(args[0]);
		boolean doitLancerElection = Boolean.parseBoolean(args[1]);


		SiteInterface egsite;
		try {
  		        System.setSecurityManager(new RMISecurityManager());
			//egsite = (SiteInterface)Naming.lookup("rmi://localhost/1234");
			
			//String str = egsite.sendMsg(new Msg());
			//System.out.println("Msgggg is :" + str);
 			ga = (GAInterface) Naming.lookup("rmi://localhost:1234/ga");
			Site si = new Site(num_site, false);
			Naming.rebind("site" + si.getNumero(), si);
			ga.demandeAjouter(si.getNumero());
			if(doitLancerElection){
				Thread.sleep(3000);
				si.lancerElection(siteList);
			}		
		
			}catch (Exception e) {
				System.out.println("SiteClient exception: " + e);
				}
		}
}