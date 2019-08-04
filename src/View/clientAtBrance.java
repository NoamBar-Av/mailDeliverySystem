package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controller.Controller;

public class clientAtBrance {

private JFrame frame = new JFrame("Parcel PickUp system");
private JTextField text = new JTextField(16);  
private JLabel lable=new JLabel("הכנס ת.ז ");
private JButton submit =new JButton("קח מספר");//creating instance of JButton 
private int num;
private JLabel Qnum=new JLabel("");
	
	public clientAtBrance()
	{
		setBound();
		add();		
		frame.setSize(700,300); 
		frame.setLayout(null);
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
		submit.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						Controller controlBranch= new Controller();
						num=controlBranch.ControllerBranch(text.getText());
						Integer num2=num;
						Qnum.setText(num2.toString());
					}
				});
	}
	public void setBound()
	{
		submit.setBounds(150,100,150,30);
		lable.setBounds(550,100,100, 30);
		text.setBounds(350,100,150, 30);
		Qnum.setBounds(150,150,150,30);
	}
	public void add()
	{
		frame.add(text); 
		frame.add(lable);  
		frame.add(submit);
		frame.add(Qnum);
	}
}
