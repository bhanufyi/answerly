
import java.rmi.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class MainClient implements ActionListener{


	HashMap<Question, LinkedList<Answer>> reciever;
	Question presentquestion;

	JFrame MainFrame,f;
	ClientSearchInterface  st;
	JTextArea answerarea,questionarea,tabbedquestionarea,tabbedanswerarea;
	JButton questionsubmit,lookforanswers;

	JScrollPane questionpane,answerpane,tabbedjscrollqpane,tabbedanswerpane;

    String topicstring;

	JPanel toppanel,leftpanel,Mainpanel,bottompanel,rightpanel,questionpanel,tabbedanswerpanel;
	JButton c,python,java;
    JTabbedPane tabbedpane;
	JLabel handlename ,username; 


	JButton postaquestion = new JButton("post a question");

	JButton signout = new JButton("sign out");

	JButton submit = new JButton("submit");



	MainClient(){
            
		try {
			st  = (ClientSearchInterface)Naming.lookup("rmi://localhost:1099/TheSolver");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainFrame = new JFrame();
		toppanel  = new JPanel();
		leftpanel = new JPanel();
		Mainpanel = new JPanel();
		rightpanel = new JPanel();
		bottompanel = new JPanel();
		
		questionpanel = new JPanel();
		
		questionsubmit = new JButton("questionsubmit");
		
		questionsubmit.addActionListener(this);
		
		lookforanswers = new  JButton("lookforanswers");
		
		lookforanswers.addActionListener(this);
		
		
		tabbedquestionarea = new JTextArea("",6,50);
		
		tabbedanswerarea = new JTextArea("answers would come here",8,50);
		
		tabbedanswerpane = new JScrollPane(tabbedanswerarea);
		
		tabbedanswerarea.setEditable(false);
		
		tabbedanswerpanel = new JPanel();
		
		tabbedanswerpanel.add(tabbedanswerpane);
		
		tabbedjscrollqpane = new JScrollPane(tabbedquestionarea);
		
		questionpanel.add(tabbedjscrollqpane);
		questionpanel.add( questionsubmit);
		
		tabbedpane =  new JTabbedPane(JTabbedPane.TOP);
		//username = new JLabel("username");
		questionarea = new JTextArea("question goes here",5,70);
		questionpane = new JScrollPane(questionarea);
		questionarea.setEditable(false);
		answerarea = new JTextArea("",5,70);
		answerpane = new JScrollPane(answerarea);
		
		c = new JButton("c");
		python = new JButton("python");
		java = new JButton("java");
		//datastructures = new JButton("datastructures");

		toppanel.setBackground(new Color(255,155,155));
		toppanel.setPreferredSize(new Dimension(60,60));
		handlename = new JLabel("Answerly",SwingConstants.CENTER);
		handlename.setFont(new Font("Serif",Font.PLAIN,20));
		
		username = new JLabel("Admin",SwingConstants.CENTER);
		
		username.setFont(new Font("Roboto",Font.BOLD,24));
		
	
		toppanel.setLayout(new BorderLayout());
		//toppanel.setSize(800, 300);

		toppanel.add(handlename,BorderLayout.CENTER);
		toppanel.add(postaquestion,BorderLayout.WEST);


		toppanel.add(signout,BorderLayout.EAST);


		signout.addActionListener(this);


		leftpanel.setBackground(new Color(253,212,242));

		leftpanel.setLayout(new GridLayout(5,1,5,5));

		c.addActionListener(this);
		python.addActionListener(this);
		java.addActionListener(this);
		
		postaquestion.addActionListener(this);
		submit.addActionListener(this);
		

		leftpanel.add(c);
		leftpanel.add(python);
		leftpanel.add(java);
		//leftpanel.add(datastructures);
        
		rightpanel.add(username,BorderLayout.CENTER);
		rightpanel.setBackground(new Color(255,65,92));

		Mainpanel.setBackground(new Color(45,35,72));

		Mainpanel.setLayout(new BorderLayout());



		Mainpanel.add(questionpane,BorderLayout.NORTH);

		Mainpanel.add(answerpane,BorderLayout.CENTER);
		//Mainpanel.add(submit,BorderLayout.SOUTH);
		//Mainpanel.add(lookforanswers);
		
		bottompanel.setLayout(new BorderLayout());
		bottompanel.add(submit,BorderLayout.EAST);
		bottompanel.add(lookforanswers,BorderLayout.WEST);
		
		Mainpanel.add(bottompanel,BorderLayout.SOUTH);
		
		//tabbedanswerpanel.add(tabbedanswerpane);
		tabbedpane.add("main",Mainpanel);
		
		tabbedpane.add("answers",tabbedanswerpanel);
		
		tabbedpane.add("postquestion",questionpanel);
		
		MainFrame.add(toppanel,BorderLayout.NORTH);
		MainFrame.add(leftpanel,BorderLayout.WEST);
		MainFrame.add(tabbedpane,BorderLayout.CENTER);
		MainFrame.add(rightpanel,BorderLayout.EAST);

		MainFrame.setSize(800,800);
		MainFrame.setVisible(true);	
	}


	public static void main(String args[]) {

		new MainClient();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == submit) {
			if(answerarea.getText()!= "") {
				String k = answerarea.getText();
				
				try { 
					st.answeraQuestion(presentquestion.hashcode, topicstring, username.getText(), k);
					
					JOptionPane.showMessageDialog(Mainpanel, "uploaded sucessfully", "sucessful", JOptionPane.PLAIN_MESSAGE);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(Mainpanel, "please enter the answer", "error", JOptionPane.PLAIN_MESSAGE);
				answerarea.setText("");
			}
		}
		
		
		if(e.getSource() == questionsubmit) {
			
		   if(tabbedquestionarea.getText() != "") {
			   
			   String k = tabbedquestionarea.getText();
			   
			   try {
				st.postQuestion(topicstring,username.getName(),k,0);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   
			   JOptionPane.showMessageDialog(questionpanel, "question posted","successful",JOptionPane.PLAIN_MESSAGE);
			   
			   tabbedpane.setSelectedIndex(0);   
			   
		   }
		   else {
		   
		   JOptionPane.showMessageDialog(questionpanel, "please enter your question","error", JOptionPane.ERROR_MESSAGE);
		   }
		   
		}
		   
		   if(e.getActionCommand().equals("c")) {
			
			topicstring = "c";
			
			LinkedList<Answer> a;
			try {
				reciever = st.getQuestions("c");
				Set<Map.Entry<Question, LinkedList<Answer>>> entryset = reciever.entrySet();

				for(Map.Entry<Question, LinkedList<Answer>> m: entryset) {
                   
					presentquestion = m.getKey();
					a = m.getValue();
					
					String set = "";
					System.out.println("hashcode is" + presentquestion.hashcode);
					
					questionarea.setText(presentquestion.question);
					
					if(a.size() != 0) {
					for(Answer k : a) {
						
						String temp = k.ans + "\n--------\n"+"answered by-->"+k.username +"\n";
						set += temp;
						
					}
					
					tabbedanswerarea.setText(set);
						
					}
					
					else {
						tabbedanswerarea.setText("answers not available.be the first one to answer it");
					}
					
				}
				
				}catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == python ) {
			
			topicstring = "python";
			
			LinkedList<Answer> a;
			try {
				reciever  = st.getQuestions("python");
				Set<Map.Entry<Question, LinkedList<Answer>>> entryset = reciever.entrySet();

				for(Map.Entry<Question, LinkedList<Answer>> m: entryset) {

					presentquestion = m.getKey();
					a = m.getValue();
		
					
                   String set = "";
                   
                   questionarea.setText(presentquestion.question);
                   
                   if(a.size() != 0) {
					for(Answer k : a) {
						
						String temp = k.ans + "\n--------\n"+"answered by-->"+k.username +"\n";
						set += temp;
					}
					
					
					tabbedanswerarea.setText(set);
                   }
                   else {
                	   tabbedanswerarea.setText("answers not available. be the first one to answer");
                   }
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if(e.getSource() == java ) {
			
			topicstring = "java";
			
			LinkedList<Answer> a = null;
			try {
				reciever  = st.getQuestions("java");
				Set<Map.Entry<Question, LinkedList<Answer>>> entryset = reciever.entrySet();

				for(Map.Entry<Question, LinkedList<Answer>> m: entryset) {
					
                       String set = "";
                       
                       presentquestion = m.getKey();
   					a = m.getValue();
   					questionarea.setText(presentquestion.question);
					if(a.size() != 0) {
					for(Answer k : a) {
						
						String temp = k.ans + "\n--------\n"+"answered by-->"+k.username +"\n";
						set += temp;
						
					}
					tabbedanswerarea.setText(set);
					}
					else {
						tabbedanswerarea.setText("answers not available be the first one to answer it");
					}
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
			if(e.getSource() == postaquestion) {
						
						tabbedpane.setSelectedIndex(2);
					}
					
					
			if(e.getSource() == lookforanswers) {
						
						tabbedpane.setSelectedIndex(1);
					}
		
		if(e.getSource() == signout) {

			MainFrame.dispatchEvent(new WindowEvent(MainFrame, WindowEvent.WINDOW_CLOSING));
		}

	}

}





