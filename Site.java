import java.rmi.*;
import java.rmi.server.*;
 
//ça mélange avec SiteImpl
public class Site extends UnicastRemoteObject implements SiteInterface {

	public int numero;
	public SiteInterface successeur;
	public boolean isElu;
      //public static boolean veutentrer = false;
        public Site () throws RemoteException {   }
        public Site(int numero, boolean isElu) throws RemoteException{
	super();
        this.numero = numero;
        this.isElu = isElu;
	}
      	public String sendMsg(Msg msg) throws RemoteException {
		String str = msg.showMsg();
		return str;      
	}
	
	public void lancerElection(ArrayList<SiteInterface> siteList) throws RemoteException {
        if(!siteList.contains(this)) {
            siteList.add(this);
            System.out.println("ajout du site numéro " + this.getNumero());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            successeur.lancerElection(siteList);
        }else{
            SiteInterface max = this.getMaxSiteNum(siteList);
            this.proclamElu(max, siteList);
        }
    }
    	public void proclamElu(SiteInterface max, ArrayList<SiteInterface> siteList) throws RemoteException{
        if(!siteList.contains(this)){
            siteList.add(this);
            successeur.proclamElu(max, siteList);
        }else {
            max.setElu(true);
            System.out.println("Setting elu = site n°" + max.getNumero());
        }
    }

	public int getNumero() throws RemoteException{
        return numero;
    	}

    	public void setNumero(int numero) throws RemoteException{
        this.numero = numero;
    	}

    	public SiteInterface getSuccesseur() throws RemoteException{
        return successeur;
    	}

    	public void setSuccesseur(SiteInterface successeur) throws RemoteException{
        this.successeur = successeur;
    	}

    	public boolean isElu() throws RemoteException{
        return isElu;
    	}

    	public void setElu(boolean elu) throws RemoteException{
        isElu = elu;
    	}

 }