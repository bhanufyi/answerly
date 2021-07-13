import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class MainServer {
	
	public static void main(String args[]) {
	
	try {
		
		ClientSearchInterface st = new ServersideinterfaceImp();
		//rmiinterface2 rmi  = new Interface2();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099"+"/TheSolver", st);
		
		//Naming.rebind("TheHelper", rmi);
		System.out.println("ready");
	}
	catch(Exception e) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e);
	}
	}
}