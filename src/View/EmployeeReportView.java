package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Model.ConnectionManager;
import net.proteanit.sql.DbUtils;

public class EmployeeReportView extends JFrame{
	
	private static JFrame frame = new JFrame("Parcel PickUp system");
	private static JToolBar tb = new JToolBar(); 
	private static JComboBox comboBox= new JComboBox(new String[] { "item 1", "item 2", "item 3" });  
	private static JPanel panel = new JPanel(); 
	private JTable table =new JTable();
	
	public EmployeeReportView()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 600, 200);
		frame.add(scrollPane);
		scrollPane.setViewportView(table);
		
		frame.setLayout(new BorderLayout()); 
		JButton VIPclient=new JButton("לקוח מועדף");//creating instance of JButton  
		JButton ammountPerMonth=new JButton("כמות חבילות לפי חודש");//creating instance of JButton  
		JButton ammountPerClient=new JButton("כמות חבילות לפי לקוח");//creating instance of JButton  
		
		VIPclient.setBounds(100,100,200, 100);//x axis, y axis, width, height  
		ammountPerMonth.setBounds(400,100,200, 100);//x axis, y axis, width, height  
		ammountPerClient.setBounds(400,100,200, 100);//x axis, y axis, width, height  
		
		VIPclient.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int i=10;
				String query="select name, id , count(numpackage) from tbl group by name, id having count(numpackage)>10";
				System.out.println(query);
				PreparedStatement pst;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = c.prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		ammountPerMonth.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int month = localDate.getMonthValue();
				String query="select  month, count (numpackage) from tbl where month='"+month+"' ";
				System.out.println(query);
				PreparedStatement pst;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = c.prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		ammountPerClient.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String query="select  name,id, count (numpackage) from tbl group by name, id";
				System.out.println(query);
				PreparedStatement pst;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = c.prepareStatement(query);
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(VIPclient);//adding button in JFrame 
		panel.add(ammountPerMonth);//adding button in JFrame 
		panel.add(ammountPerClient);//adding button in JFrame 
		tb.add(panel); 
		
		frame.add(tb, BorderLayout.NORTH); 
		frame.setSize(700,300);//400 width and 500 height  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
}
