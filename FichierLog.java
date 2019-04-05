import java.rmi.*;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;

public class FichierLog{
	ArrayList<?> LogList = new ArrayList<>();
	Semaphore sema = new Semaphore(0);
	public FichierLog(){ }
	
	public void ChangeLog(){
	
	}
}