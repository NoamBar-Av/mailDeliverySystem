package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Model.ConnectionManager;
import net.proteanit.sql.DbUtils;

public class ClientReport {
	private static JFrame frame = new JFrame("Parcel PickUp system");
	private static JToolBar tb = new JToolBar(); 
	private static JComboBox comboBox= new JComboBox(new String[] { "item 1", "item 2", "item 3" });  
	private static JPanel panel = new JPanel(); 
	private JTable table = new JTable();
	
	private JLabel idLable=new JLabel("הכנס מספר ת.ז");
	private JTextField idTxt = new JTextField(9); 
	public ClientReport()
	{
		frame.setLayout(new BorderLayout());  
		JButton ammountPerClient=new JButton("כמות חבילות ");//creating instance of JButton  
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 300, 200);
		frame.add(scrollPane);
		scrollPane.setViewportView(table);
 
		idLable.setBounds(400,100,200, 100);
		idTxt.setBounds(600,100,150, 100);
		ammountPerClient.setBounds(200,100,150, 100);//x axis, y axis, width, height  
		
		panel.add(ammountPerClient);//adding button in JFrame 
		panel.add(idTxt);//adding button in JFrame 
		panel.add(idLable);//adding button in JFrame 
		tb.add(panel); 

		ammountPerClient.addActionListener(new ActionListener()
		{
			private int idNum;

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try {
					this.idNum=Integer.parseInt(idTxt.getText());
				}
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null,
							   "שדה ת.ז ריק","ERROR", JOptionPane.WARNING_MESSAGE);
				}
				String query="select distinct * from tbl where id='"+idNum+"' ";
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
		
		
		frame.add(tb, BorderLayout.NORTH); 
		frame.setSize(700,300);//400 width and 500 height  
		frame.setVisible(true);//making the frame visible   
		frame.setLocationRelativeTo(null);
	}

}
