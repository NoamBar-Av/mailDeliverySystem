package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller;
import Model.ConnectionManager;
import net.proteanit.sql.DbUtils;

public class clientAtHome extends JFrame{

	private JFrame frame = new JFrame("Parcel PickUp system");
	private JLabel lable=new JLabel("הוסף חבילה");
	private JLabel name=new JLabel("שם");
	private JLabel id=new JLabel("ת.ז");
	private JLabel parNum=new JLabel("מספר חבילה");
	private JLabel branch=new JLabel("סניף");
	
	private JTextField nameT = new JTextField(16);
	private JTextField idT = new JTextField(9);  
	private JTextField parNumT = new JTextField(16);  
	private JTextField branchT = new JTextField(16); 
	
	private JButton confirm=new JButton("הוסף");
	private JButton delete=new JButton("מחק");
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable();
	
	public clientAtHome()
	{
		setBound();	
		add();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Controller controlHome= new Controller();
		confirm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String query[] = new String[2];
				String action="confirm";
				int num=Integer.parseInt(idT.getText());
				controlHome.create_client(nameT.getText(),num);
				query=controlHome.handleParcel(action,parNumT.getText(),branchT.getText());
				System.out.println(query);
				PreparedStatement pst;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = (c.prepareStatement(query[0]));
					ResultSet rs=pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String query[] = new String[2];
				String action="delete";
				query=controlHome.handleParcel(action,parNumT.getText(),branchT.getText());
				System.out.println(query[0]);
				PreparedStatement pst;
				try {
					Connection c = ConnectionManager.getInstance();
					pst = (c.prepareStatement(query[0]));
					System.out.println(pst.toString());
					pst.executeUpdate();	
					pst = (c.prepareStatement(query[1]));
					System.out.println(pst.toString());
					ResultSet rs2=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					c.close();
					
				} catch (SQLException | ClassNotFoundException ee) {
					JOptionPane.showMessageDialog(null,"db is empty");
				}
			}
		});
				
		frame.setSize(700,300); 
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 300, 200);
		frame.add(scrollPane);
		scrollPane.setViewportView(table);
		
	}
	public void setBound()
	{
		lable.setBounds(300,20,100,20);
		name.setBounds(600,100,50,20);
		id.setBounds(600,125,50,20);
		parNum.setBounds(560,150,100,20);
		branch.setBounds(595,175,100,20);
		confirm.setBounds(550,205,100,30);
		delete.setBounds(400,205,100,30);
		
		nameT.setBounds(400,100,100,20);
		idT.setBounds(400,125,100,20);
		parNumT.setBounds(400,150,100,20);
		branchT.setBounds(400,175,100,20);
	}
	public void add()
	{
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
