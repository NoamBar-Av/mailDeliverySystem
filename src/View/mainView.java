package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;  
import javax.swing.JFrame;

import Model.ConnectionManager;
import Model.Database;
import Model.InsertDB;

public class mainView extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Parcel PickUp system");
	private PropertyChangeSupport support;
	
	public mainView() throws SQLException, ClassNotFoundException
	{
		support = new PropertyChangeSupport(this);
		Connection c = ConnectionManager.getInstance();
		start();
	}
	public void start()
	{
		JButton client=new JButton("����");//creating instance of JButton  
		JButton employee=new JButton("����");//creating instance of JButton  
		client.setBounds(100,100,200, 100);//x axis, y axis, width, height  
		employee.setBounds(400,100,200, 100);//x axis, y axis, width, height   

		frame.add(client);//adding button in JFrame  
		frame.add(employee);//adding button in JFrame  
		
		client.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new clientView();
			}
		});
		
		employee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new employeeView();
			}
		});
		
		frame.setSize(700,300);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener pcl)
	{
		this.support.addPropertyChangeListener(pcl);
	}
	public void removePropertyChangeListener(java.beans.PropertyChangeListener pcl)
	{
		this.support.removePropertyChangeListener(pcl);
	}
}
