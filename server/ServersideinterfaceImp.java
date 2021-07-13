import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ServersideinterfaceImp extends UnicastRemoteObject implements ClientSearchInterface ,Comparator

{   
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2593788773485854031L;

	protected ServersideinterfaceImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String username, String password) throws RemoteException , IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<Question,LinkedList<Answer>> getQuestions(String topic)  throws RemoteException ,IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		System.out.println("getting a question");
		
		FileInputStream fis = new FileInputStream(new File("database2.txt"));
		ObjectInputStream objinp = new ObjectInputStream(fis);
		
		Controller m = (Controller) objinp.readObject();
		
		System.out.println(m.c + " "+ m.python + " " + m.java);
		
		HashMap<Question,LinkedList<Answer>> temp =  m.returnquestionans(topic);
		
		objinp.close();
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(new File("database2.txt"));
		ObjectOutputStream objop = new ObjectOutputStream(fos);
		
		objop.writeObject(m);
		
		objop.close();
		fos.close();
		
		
		
		return temp;
	}

	@Override
	public void postQuestion(String topic,String username,String question, int count) throws RemoteException,IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("posting a question");
		
		FileInputStream fis = new FileInputStream(new File("database2.txt"));
		ObjectInputStream objinp = new ObjectInputStream(fis);
		Controller k = (Controller)objinp.readObject();
		
		
		objinp.close();
		fis.close();
		
		
		
		FileOutputStream fos = new FileOutputStream(new File("database2.txt"));
		ObjectOutputStream objop = new ObjectOutputStream(fos);
		
		
		
		k.addQuestion(topic,username,question,count);
		
		System.out.println(k.c + " "+ k.python + " " + k.java);
		
		objop.writeObject(k);
		
		objop.close();
		fos.close();	
		
	}

	@Override
	public void answeraQuestion(Integer i,String topic,String username,String answer) throws RemoteException,IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("answering a  question");
		
		FileInputStream fis = new FileInputStream(new File("database2.txt"));
		ObjectInputStream objinp = new ObjectInputStream(fis);
		Controller k = (Controller)objinp.readObject();
		
		fis.close();
		objinp.close();
		
		
		FileOutputStream fos = new FileOutputStream(new File("database2.txt"));
		ObjectOutputStream objop = new ObjectOutputStream(fos);
		
		
		
		k.addAnswer( i, topic, username, answer);
		
		System.out.println(k.c + " "+ k.python + " " + k.java);
		
		objop.writeObject(k);
		
		objop.close();
		fos.close();	
		
	}

	@Override
	public int compare(Object a1, Object a2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


