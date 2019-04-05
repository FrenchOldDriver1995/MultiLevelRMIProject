import java.net.MalformedURLException;
import java.rmi.*;


//c'est pareil que GetionnaireAnneau

public class Gestion extends UnicastRemoteObject implements GAInterface {
    public static int nb_machines;

//    public static ArrayList<Integer> liste_machine;

    public static SiteInterface site1, site2, site3, site4;
//    public static int compteur_nb_machines = 0;

    //Constructeur
    public Gestion(int nbmachines) throws RemoteException {
        nb_machines = nbmachines;

//        liste_machine = new ArrayList<>();

    }


    //Methode appele par un Site pour une demande d'ajout
    public void demandeAjouter(int numeroSite) throws RemoteException{
//        liste_machine.add(numeroSite);
        try{
            switch (numeroSite){
                case 1:
                    site1 = (SiteInterface) Naming.lookup("rmi://localhost:1234/site1");
                    break;
                case 2:
                    site2 = (SiteInterface) Naming.lookup("rmi://localhost:1234/site2");
                    break;
                case 3:
                    site3 = (SiteInterface) Naming.lookup("rmi://localhost:1234/site3");
                    break;
                case 4:
                    site4 = (SiteInterface) Naming.lookup("rmi://localhost:1234/site4");
                    site1.setSuccesseur(site2);
                    site2.setSuccesseur(site3);
                    site3.setSuccesseur(site4);
                    site4.setSuccesseur(site1);
                    break;
                default:
                    break;
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void main (String[ ] args) {
        try{
            Naming.rebind ("ga", new Gestion(4));
            System.out.println ("Serveur pret") ;

        } catch (RemoteException e) {
            System.out.println("Erreur GA : " + e) ;
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("Erreur GA : " + e) ;
            e.printStackTrace();
        }

    }
}
