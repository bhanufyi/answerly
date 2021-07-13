
import java.io.*;
import java.util.*;

class Controller implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909964622062674864L;

	TreeMap<Integer,LinkedList<Answer>> c,python,java;
	
	HashMap<Integer,Question> clinker,pythonlinker,javalinker;
	
	LinkedList<Answer> answerslist;
    
	 String topic;
	 Question q;
	 Answer a;
	 
	 String question;
	 String answer;
	
	Controller(){	
		
		c = new TreeMap<Integer,LinkedList<Answer>>();
		python = new TreeMap<Integer,LinkedList<Answer>>();
		java = new TreeMap<Integer,LinkedList<Answer>>();
		
		 clinker = new HashMap<Integer,Question>();
		 
		 pythonlinker = new HashMap<Integer,Question>();
		 
		 javalinker = new HashMap<Integer,Question>();
		
	}
	
	void  addQuestion(String topic,String username,String question,int count) {
		
		if(topic.equals("c")) {
			
			Question q = new Question(topic,username,question,count);
			clinker.put(q.hashcode,q);
			
			System.out.println(clinker);
			//System.out.println("Adding to "+q);
			c.putIfAbsent(q.hashCode(),new LinkedList<Answer>());
			
			System.out.println("add question"+q.hashcode+""+c);
			
			System.out.println(clinker.get(1756590992));
			
		}
		
		if(topic.equals("python")) {
			
			Question q = new Question(topic,username,question,count);
			pythonlinker.put(q.hashcode,q);
			//System.out.println("Adding to "+q);
			python.putIfAbsent(q.hashCode(),new LinkedList<Answer>());
			
			System.out.println("add question"+q.hashcode+""+c);
			
		}
		
		if(topic.equals("java")) {
			
			Question q = new Question(topic,username,question,count);
			javalinker.put(q.hashcode,q);
			//System.out.println("Adding to "+q);
			java.putIfAbsent(q.hashCode(),new LinkedList<Answer>());
			
			System.out.println("add question"+q.hashcode+""+c);
			
		}
		
		
		
	}
	
	
	
	HashMap<Question,LinkedList<Answer>> returnquestionans(String topic){
		
		HashMap<Question,LinkedList<Answer>> temp = null;
		
		if(topic.equals("c")) {
			
			 temp = new HashMap<Question,LinkedList<Answer>>();
			 
		Set<Integer> s = c.keySet();
		int x = s.size();
		
		
		
        Object[] a = s.toArray();
        
        Random r = new Random();
        
        int k = r.nextInt(x);
        
        System.out.println(x+ "    "+k);
        
        
        LinkedList<Answer> list = c.get((Integer)a[k]);
        
        System.out.println((Integer)a[k]+" " + "problem causing");
        
        System.out.println(clinker.get((Integer)a[k]));
        
			temp.put(clinker.get((Integer)a[k]),list);
			
		}
		
		
		if(topic.equals("python")) {
			
			 temp = new HashMap<Question,LinkedList<Answer>>();
			
			 Set<Integer> s = python.keySet();
				int x = s.size();
				
		        Object[] a = s.toArray();
		        
		        Random r = new Random();
		        
		        int k = r.nextInt(x);
		        
		        
		        LinkedList<Answer> list = python.get((Integer)a[k]);
		        
					
					
					temp.put(pythonlinker.get((Integer)a[k]),list);
					
			
			
		}
		
		if(topic.equals("java")) {
			
			 temp = new HashMap<Question,LinkedList<Answer>>();
			
			 Set<Integer> s = java.keySet();
				int x = s.size();
				
		        Object[] a = s.toArray();
		        
		        Random r = new Random();
		        
		        int k = r.nextInt(x);
		        
		        
		        LinkedList<Answer> list = java.get((Integer)a[k]);
		        
					
					
					temp.put(javalinker.get((Integer)a[k]),list);
					
			
		}
		return temp;	
		
	}
	
	
	
	void addAnswer(Integer i,String topic,String username,String answer) {
		
		
		if(topic.equals("c")) {

		answerslist = 	c.get(i);
		
		Answer a = new Answer(answer,topic,username);
		
		answerslist.add(a);
		
		c.put(i,answerslist);	
		}
		
		if(topic.equals("python")) {
			answerslist = 	python.get(i);
			
			Answer a = new Answer(answer,topic,username);
			
			answerslist.add(a);
			
			python.put(i,answerslist);

			
			}
		
		
		if(topic.equals("java")) {
			answerslist = 	java.get(i);
			
			Answer a = new Answer(answer,topic,username);
			
			answerslist.add(a);
			
			java.put(i,answerslist);

				
			}
	}
	
	
	void initialize() {
		
		Question p =new Question("c","bhanu","what is a pointer",0);
		Answer a = new Answer("idk","c","admin");
		
		LinkedList<Answer> l ;
		clinker.put(p.hashcode, p);
		c.put(p.hashCode(),new LinkedList<Answer>());
		
		l= c.get(p.hashcode);
		l.add(a);
		c.put(p.hashcode,l);
		
		
		p = new Question("python","prash","what is ducktype casting",0);
		pythonlinker.put(p.hashcode, p);
		python.put(p.hashCode(),new LinkedList<Answer>());
		a = new Answer("idk","python","admin");
		
		
		l= python.get(p.hashcode);
		l.add(a);
		python.put(p.hashcode,l);
		
		p = new Question("java","suhrut","what is serialization",0);
		javalinker.put(p.hashcode, p);
		java.put(p.hashCode(),new LinkedList<Answer>());
		a = new Answer("idk","java","admin");
		
		
		l= java.get(p.hashcode);
		l.add(a);
		java.put(p.hashcode,l);
		
		
		
		
	}
	
	public static void main(String args[]) throws IOException {
		
		Controller k = new Controller();
		
		FileOutputStream fos  = new FileOutputStream(new File("database2.txt"));
		ObjectOutputStream objop = new ObjectOutputStream(fos);
		
		
		
		k.initialize();
		
		objop.writeObject(k);
		//System.out.println(k.c +" "+k.python+" "+k.java);
		
		objop.close();
		fos.close();
	}
	
}

	
	
	




