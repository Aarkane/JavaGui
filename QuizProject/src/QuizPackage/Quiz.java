package QuizPackage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz {
	public static void main(String[] args) {
		new Quiz();
	}
	public Quiz(){
		JFrame QuizGUI = new JFrame();
		QuizGUI.setTitle("Quiz");
		QuizGUI.setSize(400, 600);
		QuizGUI.setResizable(false);
		QuizGUI.setLocationRelativeTo(null);
		QuizGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel title = new JLabel("Quiz Game");
		title.setBounds(0,0,100,50);
		
		
		panel.add(title);
		QuizGUI.add(panel);
	}
}
