package Model;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class parcel_list {
	
	private static Integer sirealNum=1; 
	private LinkedHashMap<Integer,parcel> hashMap;
	public parcel_list()
	{
		this.hashMap=new LinkedHashMap<Integer,parcel>();
	}
	
	public String insertElement(parcel pac)
	{	
		if ((!this.hashMap.containsValue(pac)))
		{
			this.hashMap.put(sirealNum, pac);
			sirealNum++;
			return "parcel ok!";
		}
    	else
    		return "alreday exsist";
	}	
	
	public Integer getParKey(String num) 
	{
		int key= 0;
		    for (Entry<Integer,parcel> entry : hashMap.entrySet()) {
		        if (entry.equals(num)) {
		            key=entry.getKey();
		        }
		    }
		return key;
		    
	}
	public String deletElement(int key)
	{	
		if ((this.hashMap.containsKey(key)))
		{
			this.hashMap.remove(key);
			return "deleted!";
		}
    	else
    		return "dose not exsist";
	}

	public parcel find(int id) throws IllegalArgumentException
	{
		return hashMap.get(id);
	}
}
