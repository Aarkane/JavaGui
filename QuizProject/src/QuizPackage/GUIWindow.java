package QuizPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUIWindow {

	JList<String> list1;
	JLabel label1;
	JTextField text1;
	JButton button1;
	DefaultListModel<String> listmodel;
	JFrame thisGUI;
	
	public static void main(String[] args) {
		new GUIWindow();
	}
		
	public GUIWindow(){
		System.out.println("Hello World");
		thisGUI = new JFrame();
		thisGUI.setTitle("My First GUI");
		thisGUI.setSize(408, 400);
		thisGUI.setResizable(false);
		thisGUI.setLocationRelativeTo(null);
		thisGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ListenForButton lForButton = new ListenForButton();
		ListenForText lForText = new ListenForText();
		ListenForOpenItem lForOpenItem = new ListenForOpenItem();
		ListenForCopyItem lForCopyItem = new ListenForCopyItem();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		label1 = new JLabel();
		label1.setText("Hello World");
		label1.setBounds(0,0,398,30);
		label1.setOpaque(true);
		label1.setBackground(Color.pink);
		label1.setFont(new Font(label1.getName(), Font.PLAIN, 18));
		panel.add(label1);
		
		text1 = new JTextField(20);
		text1.setBounds(0,35, 250, 30);
		text1.addActionListener(lForText);
		panel.add(text1);
		
		button1  = new JButton("OK");
		button1.setBounds(255, 35, 135, 30);
		button1.addActionListener(lForButton);
		panel.add(button1);
		
		listmodel = new DefaultListModel<String>();
		list1 = new JList<String>(listmodel);
		panel.add(list1);
		
		
		JScrollPane listScroller = new JScrollPane(list1);
		listScroller.setBounds(0,  70,  400,  300);
		panel.add(listScroller);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
		openMenuItem.addActionListener(lForOpenItem);
		fileMenu.add(openMenuItem);
		fileMenu.addSeparator();
		JMenuItem printMenuItem = new JMenuItem("Print", KeyEvent.VK_P);
		fileMenu.add(printMenuItem);
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.addActionListener(lForCopyItem);
		editMenu.add(copyMenuItem);
		
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		thisGUI.add(menuBar);
		thisGUI.setJMenuBar(menuBar);
		
		
		
		thisGUI.add(panel);
		thisGUI.setVisible(true);

	}
	
	//Add Action Listeners Here
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Button has been clicked");
			AddToList();
			
		}
		
	}
	
	private class ListenForText implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AddToList();
		}
		
	}
	
	private class ListenForOpenItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Clicked Open Menu");
		}
		
	}
	
	private class ListenForCopyItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(thisGUI, text1.getText());
		}
		
	}
	
	private void AddToList() {
		String txt = text1.getText();
		txt = txt.trim();
		if (!txt.isEmpty()) {
			if (!listmodel.contains(txt)) {
				listmodel.addElement(txt);
				text1.setText(null);
			}
		}
		else {
			JOptionPane.showMessageDialog(thisGUI, "Please enter some text");
		}
	}

}