package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class employeeView {
	private JFrame frame = new JFrame("Parcel PickUp system");
	
	public employeeView()
	{
		JButton Queue=new JButton("התור הבא");//creating instance of JButton  
		JButton reports=new JButton("דוחות");//creating instance of JButton  
		Queue.setBounds(100,100,200, 100);//x axis, y axis, width, height  
		reports.setBounds(400,100,200, 100);//x axis, y axis, width, height    
		
		reports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EmployeeReportView();
			}
		});
		
		Queue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EmployeeHandleClient();
			}
		});
		
		frame.add(Queue);//adding button in JFrame  
		frame.add(reports);//adding button in JFrame  
		
		frame.setSize(700,300);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
}
