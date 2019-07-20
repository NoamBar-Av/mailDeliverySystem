package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class clientView 
{
	private JPanel panel= new JPanel ();
	private JFrame frame = new JFrame("Parcel PickUp system");
	
	public clientView()
	{
		JButton home=new JButton("בית");//creating instance of JButton  
		JButton brance=new JButton("סניף");//creating instance of JButton  
		JButton report=new JButton("דוחות");//creating instance of JButton  
		home.setBounds(100,100,100, 100);//x axis, y axis, width, height  
		brance.setBounds(300,100,100, 100);//x axis, y axis, width, height    
		report.setBounds(500,100,100, 100);//x axis, y axis, width, height    
		
		frame.add(home);//adding button in JFrame  
		frame.add(brance);//adding button in JFrame  
		frame.add(report);//adding button in JFrame  
		
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new clientAtHome();
			}
		});
		
		brance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new clientAtBrance();
			}
		});
		
		report.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//	new employeeView();
			}
		});
		
		
		frame.setSize(700,300);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
}
