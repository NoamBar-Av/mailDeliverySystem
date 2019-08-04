package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import Model.Client;
import Model.Database;
import Model.QueueNum;
import Model.parcel_list;
import View.clientAtBrance;

public class Controller {
	
	private clientAtBrance branchView;
	private parcel_list list;
	private int myTextField;
	private QueueNum Qnum;
	private Client client;
	private static int index=0;
	public Controller()	{}
	public int ControllerBranch(String text)
	{
		if (!text.equals(""))
		{
			try {
				myTextField=Integer.parseInt(text);
				if (ifContainsClient(myTextField))
				{	
					try {
						client=Client.getClient(myTextField);
					}
					catch(Exception e)
					{
						System.out.println("no such client");
					}
					System.out.println(client.getName());
					client.setQnum();
					int num=client.getQnum();
					System.out.println(num);
					return num;		
				}	
				else
				{
					JOptionPane.showMessageDialog(null,
							   "ת.ז לא קיימת","ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,
					   "ת.ז מכילה מספרים בלבד","ERROR", JOptionPane.WARNING_MESSAGE);
			}
			return 0;
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					   "שדה ריק","ERROR", JOptionPane.WARNING_MESSAGE);
		return 0;	
		}
	}
	
	public boolean ifContainsClient(int myTextField)
	{
		for (Client c: Client.getClientList())
		{
			if (c.getId().equals(myTextField))
				return true;
		}
		return false;
	}
	public void create_client(String name, int id)
	{
		if (!ifContainsClient(id))
		{
			this.client= new Client(name,id);
			Client.getClientList().add(client);
		}
	}

	public String[] handleParcel(String action,String number,String location)
	{
		String ar[] = new String[2];
		if (action.equals("confirm"))
		{
			client.create_new_parcel(number, false, location);
			String pstShow=client.showFromDB(number, false, location);
			ar[0]=pstShow;
			return ar;
		}		
		else
		{
			int key=client.getList().getParKey(number);
			client.getList().deletElement(key);
			String deleteQuery=client.DeleteFromDB(number);
			String pstShow=client.showFromDB(number, false, location);
			ar[0]=deleteQuery;
			ar[1]=pstShow;
			return ar;
		}	
	}
	public static void  setIndex()
	{
		index++;
	}
	public String getClientName()
	{
		String name=Client.getClientList().get(index).getName();
		return name;
	}
	public Integer getClientID()
	{
		Integer id=Client.getClientList().get(index).getId();
		return id;
	}
	public Integer getClientQnum()
	{
		Integer Qnum=Client.getClientList().get(index).getQnum();
		return Qnum;
	}
}
