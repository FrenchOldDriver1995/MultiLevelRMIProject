import java.rmi.*;
import java.io.Serializable;
public class Msg implements Serializable{
	//Serializable for sending msg
	int[] msg_election={};
	int[] msg_confirm={};
	int num_candidat=-1;
	public String showMsg(){
		return "message is "+Integer.toString(num_candidat);
	}
}