package View;

import javax.swing.JButton;
import javax.swing.JFrame;

public class employeeView {
	private JFrame frame = new JFrame("Parcel PickUp system");
	
	public employeeView()
	{
		JButton Queue=new JButton("get Queue");//creating instance of JButton  
		JButton reports=new JButton("reports");//creating instance of JButton  
		Queue.setBounds(100,100,200, 100);//x axis, y axis, width, height  
		reports.setBounds(400,100,200, 100);//x axis, y axis, width, height    
		
		frame.add(Queue);//adding button in JFrame  
		frame.add(reports);//adding button in JFrame  
		
		frame.setSize(700,300);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
}
