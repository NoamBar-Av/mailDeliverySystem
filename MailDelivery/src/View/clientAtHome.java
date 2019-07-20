package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.Controller;

public class clientAtHome {

	private JFrame frame = new JFrame("Parcel PickUp system");
	private JLabel lable=new JLabel("הוסף חבילה");
	private JLabel name=new JLabel("שם");
	private JLabel id=new JLabel("ת.ז");
	private JLabel parNum=new JLabel("מספר חבילה");
	private JLabel branch=new JLabel("סניף");
	private JTextField nameT = new JTextField(16);
	private JTextField idT = new JTextField(16);  
	private JTextField parNumT = new JTextField(16);  
	private JTextField branchT = new JTextField(16); 
	private JButton confirm=new JButton("הוסף");
	private JButton delete=new JButton("מחק");
	private JTextArea textArea;

	public clientAtHome()
	{
		textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(true);
		
		setBound();	
		add();
		
		confirm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String action="confirm";
				Controller controlHome= new Controller();
				int num=Integer.parseInt(idT.getText());
				controlHome.create_client(nameT.getText(),num);
				controlHome.handleParcel(action,parNumT.getText(),branchT.getText());
			}
		});
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String action="delete";
				Controller controlHome= new Controller();
				controlHome.handleParcel(action,parNumT.getText(),branchT.getText());
			}
		});
		
		frame.setSize(700,300); 
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
	public void setBound()
	{
		lable.setBounds(300,30,100,20);
		name.setBounds(600,100,50,20);
		id.setBounds(600,125,50,20);
		parNum.setBounds(560,150,100,20);
		branch.setBounds(595,175,100,20);
		textArea.setBounds(20,50,300,200);
		confirm.setBounds(550,205,100,30);
		delete.setBounds(400,205,100,30);
		
		nameT.setBounds(400,100,100,20);
		idT.setBounds(400,125,100,20);
		parNumT.setBounds(400,150,100,20);
		branchT.setBounds(400,175,100,20);
	}
	public void add()
	{
		frame.add(textArea);
		frame.add(lable);
		frame.add(name); 
		frame.add(id); 
		frame.add(parNum); 
		frame.add(branch); 
		frame.add(nameT); 
		frame.add(idT); 
		frame.add(parNumT); 
		frame.add(branchT); 
		frame.add(confirm);
		frame.add(delete);
	}
}
