package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Client;
import Model.ConnectionManager;
import net.proteanit.sql.DbUtils;

public class EmployeeHandleClient {
	
	Controller controlGetClient= new Controller();
	private JFrame frame = new JFrame("Parcel PickUp system");
	private JButton taken=new JButton("נלקח");
	private JButton next=new JButton("תור הבא");
	private JLabel name=new JLabel("שם");
	private JLabel idNum=new JLabel("ת.ז");
	private JLabel numText=new JLabel("מספר תור");
	
	private JTable table =new JTable();
	
	private JLabel nameValue =new JLabel("");
	private JLabel idNumValue=new JLabel("");
	private JLabel numTextVAlue=new JLabel("");
	private String nameText;
	private String id="0";
	private String Qnum;
	public EmployeeHandleClient()
	{
		JScrollPane scrollPane = new JScrollPane(table); 
		scrollPane.setViewportView(table);
		
		table.setBounds(20,50,300,200);
		taken.setBounds(550,220,80,30);
		next.setBounds(450,220,80,30);
		
		numText.setBounds(550,50,100,30);
		name.setBounds(580,100,100,30);
		idNum.setBounds(582,150,100,30);
		
		nameValue.setBounds(450,100,100,30);
		idNumValue.setBounds(450,150,100,30);
		numTextVAlue.setBounds(450,50,100,30);
		try {
			this.nameText= controlGetClient.getClientName();
			this.id=controlGetClient.getClientID().toString();
			this.Qnum=controlGetClient.getClientQnum().toString();
			Controller.setIndex();
			nameValue.setText(nameText);
			idNumValue.setText(id);
			numTextVAlue.setText(Qnum);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		
		getTable(id);
		
		next.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new EmployeeHandleClient();
			}
		});
		
		
		taken.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String query="UPDATE tbl SET istaken='yes' where id='"+id+"' ";
				String query2="select distinct * from tbl where id='"+id+"' ";
				System.out.println(query);
				PreparedStatement pst;
				PreparedStatement pst2;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = (c.prepareStatement(query));
					pst.execute();
					pst2 = c.prepareStatement(query2);
					ResultSet rs=pst2.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		scrollPane.setBounds(50, 50, 300, 200);
		frame.add(scrollPane);
		frame.add(taken);
		frame.add(next);
		frame.add(numText);
		frame.add(name);
		frame.add(idNum);
		frame.add(nameValue);
		frame.add(idNumValue);
		frame.add(numTextVAlue);
		
		frame.setSize(700,300); 
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}
	public void getTable(String id)
	{
		String query="select distinct * from tbl where id='"+id+"' ";
		System.out.println(query);
		PreparedStatement pst;
		try {
			Connection c = ConnectionManager.getInstance();
			pst = (c.prepareStatement(query));
			ResultSet rs=pst.executeQuery();	
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
