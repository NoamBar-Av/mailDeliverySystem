package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Client 
{
	private static int index=1;
	private String name;
	private Integer id;
	private parcel_list list;
	private enum status  {home, postoffice}
	private static ArrayList<Client> clientList= new ArrayList<Client>();
	private int Qnum=0;
	public Client(String name, Integer id) 
	{
		setName(name);
		setId(id);
		newList();
		insertClient();
		setQnum();
		System.out.println("client created");
		
	}
	public void insertClient()
	{
		System.out.println("test");
		clientList.add(this);
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
		System.out.println(this.getName()+" "+ this.getId() +" " +number +" "+ location);
		insertToDatabase(number, false, location);
	}
	public static ArrayList<Client> getClientList() {
		return clientList;
	}
	public void insertToDatabase(String number, boolean ststus,String location)
	{
		try 
		{
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month = localDate.getMonthValue();
			int year=localDate.getYear();
			String monthstr = "" + month;
			String yearstr = "" + year;
			String insert = "INSERT INTO tbl (name,id,numpackage,branch,istaken,month,year) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?)";
			Connection c = ConnectionManager.getInstance();		
			PreparedStatement pst = c.prepareStatement(insert);
			pst.setString(1, this.getName());
			pst.setString(2, this.getId().toString());
			pst.setString(3, number);
			pst.setString(4, location);
			pst.setString(5, "No");
			pst.setString(6, monthstr);
			pst.setString(7, yearstr);
			System.out.println(pst.toString());
			pst.execute();
	        //c.commit();
		} 
		catch(Exception e)
		{
			System.out.println("problem"+e);
			
		}	
	}
	public String showFromDB(String number, boolean ststus,String location)
	{
		try       //בעת לחיצה על הכפתור LOAD.....................
		{
			String valueOfId= this.getId().toString();
			String query="select * from tbl where id='"+valueOfId+"' ";
			return query;
		} 
		catch(Exception e1)
		{
			System.out.println("cant show"+e1);
		}
		return null;
	}
	public String DeleteFromDB(String number)
	{
		      //בעת לחיצה על הכפתור LOAD....................
		String query="delete from tbl where numpackage ='"+number+"' ";
		System.out.println(query);
		System.out.println("deleted");
		list.deletElement(list.getParKey(number));
		return query;
	}
	public Integer getQnum() {
		return Qnum;
	}
	public void setQnum() {
		
		if(this.Qnum==0)
			this.Qnum= new QueueNum().getNunber();
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("name is:"+ this.name);
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public static Client getClient(int clientID)
	{
		for (Client c: clientList )
		{
			if (c.getId().equals(clientID))
				return c;
		}
		return null;
	}
}

