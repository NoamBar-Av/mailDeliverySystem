package Model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Client extends person 
{
	private parcel_list list;
	private enum status  {home, postoffice}
	private static LinkedHashMap<Integer,Client> clientList= new LinkedHashMap<Integer,Client>();
	
	public Client(String name, Integer id) 
	{
		super(name, id);
		newList();
		insertClient();
	}
	public void insertClient(Client this)
	{
		clientList.put(this.getId(), this);
	}
	public parcel_list getList() {
		return list;
	}
	public void newList() {
		this.list = new parcel_list();
	}
	public void create_new_parcel(String number, boolean ststus,String location)
	{
		parcel parcel= new parcel(number, false, location);
		list.insertElement(parcel);
	}
	public static LinkedHashMap<Integer, Client> getClientList() {
		return clientList;
	}
}

