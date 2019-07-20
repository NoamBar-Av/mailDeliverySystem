package Model;
import java.sql.Timestamp;

public class parcel 
{
	private String number;
	private boolean status;
	private String location;
	
	public parcel(String number, boolean ststus,String location)
	{
		setLocation(location);
		setStatus(ststus);
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
