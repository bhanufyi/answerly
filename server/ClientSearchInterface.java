import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
import java.io.*;
public interface ClientSearchInterface extends Remote
{
	public boolean validate(String username,String password) throws RemoteException, IOException,ClassNotFoundException;
	
	public HashMap<Question,LinkedList<Answer>> getQuestions(String topic) throws RemoteException,IOException,ClassNotFoundException;
	
	public void postQuestion(String topic,String username,String question,int count)throws RemoteException, IOException,ClassNotFoundException;
	public void answeraQuestion(Integer i,String topic,String username,String answer)throws RemoteException , IOException,ClassNotFoundException;
	
}
