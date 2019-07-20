package Controller;

import javax.swing.JOptionPane;
import Model.Client;
import Model.QueueNum;
import Model.parcel_list;
import View.clientAtBrance;

public class Controller {
	
	private clientAtBrance branchView;
	private parcel_list list;
	private int myTextField;
	private QueueNum Qnum;
	private Client client;
	public Controller(){}
	public int ControllerBranch(String text)
	{
		if (!text.equals(""))
		{
			try {
				myTextField=Integer.parseInt(text);
				if (getClient(myTextField))
				{
					 return get_Qnumber();		
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
	
	public boolean getClient(int myTextField)
	{
		if (Client.getClientList().containsKey(myTextField))
			return true;
		else
			return false;
	}
	public int get_Qnumber()
	{
		int num;
		Qnum=new QueueNum();
		num=Qnum.getNunber();
		return num;
	}
	
	public void create_client(String name, int id)
	{
		this.client= new Client(name,id);
	}
	public void handleParcel(String action,String number,String location)
	{
		if (action.equals("confirm"))
		{
			client.create_new_parcel(number, false, location);
		}		
		else
		{
			int key=client.getList().getParKey(number);
			client.getList().deletElement(key);			
		}	
	}
}
