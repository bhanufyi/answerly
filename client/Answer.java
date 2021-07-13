import java.io.*;
import java.util.*;
public class Answer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7971371972988338537L;
	String ans;
	String topic;
	String username;
	Answer(String ans,String topic ,String username){
		
		this.ans = ans;
		this.topic = topic;
		this.username = username;
		
	}
	
	void setAnswer(String ans) {
		this.ans = ans;
	}
	
	String getAnswer() {
		return ans;
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
	
	
	public String toString() {
		return ans;
		
	}

}
