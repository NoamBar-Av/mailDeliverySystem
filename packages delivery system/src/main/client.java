package main;
import java.util.Scanner; 

public class client {
	private String name;
	private int id;
	private String number;
	private list_of_packages <String> hashmap= new list_of_packages<String>();
		
	public void enter_parcelnumber()
	{
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter parcel number");
		this.setNumber(myObj.nextLine());
		new_package <String> pac= new new_package<String>();
		hashmap.enterNewParcel(pac);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
