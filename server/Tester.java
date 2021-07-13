import java.io.*;
import java.rmi.*;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.TreeMap;


public class Tester extends UnicastRemoteObject implements Serializable {
	
	ServersideinterfaceImp serverimp;
	
	Tester() throws RemoteException{
		super();
		serverimp = new ServersideinterfaceImp();
		
	}
	
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		
		

		
		Tester t = new Tester();
		
		HashMap<Question,LinkedList<Answer>> temp = t.serverimp.getQuestions("java");
		
		System.out.println(temp);
				
				
 	}
	
}

