import java.io.Serializable;
import java.util.*;
public class Question implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2298152844980908110L;
	String question;
	String topic ;
	String username;
	int count =0;
	final int hashcode;
	
	
	Question(String topic,String username,String question,int count){
		
		this.topic = topic;
		this.question = question;
		this.username = username;
		this.count = count;
		
		hashcode = this.hashCode();
		System.out.println(hashcode);
	}
	
	void setQuestion(String question) {
		this.question = question;
	}
	
	String getQuestion() {
		
		return question;
		
	}
	
	void setTopic(String topic) {
		this.topic = topic;
	}
	
	String  getTopic() {
		return topic;
	}
	
	void setUsername(String username) {
		this.username = username;
	}
	
	String getUsername() {
		return username;
	}
	

	int nofanswers() {
		return count;
	}
	
	int returnhashcode() {
		
		 return this.hashCode();
	}
	
	public String toString() {
		
		
		
		return question;
		
	}

}
