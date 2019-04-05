import java.rmi.*;
import java.io.Serializable;
import java.util.Arrays;
public class Msg implements Serializable{

	//Serializable for sending msg

	private static final long serialVersionUID = 1122334455;

	int[] msg_election={};
	int[] msg_confirm={};
	int num_candidat=-1;
	public String showMsg(){

		return "message : candidat : "+Integer.toString(num_candidat)+
	" msg confirm : "+ Arrays.toString(msg_confirm) + " msg election : "+
	Arrays.toString(msg_election);
	
	}
	
}