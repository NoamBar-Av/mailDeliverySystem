package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class list_of_packages<V> {
	
	LinkedHashMap<Integer,new_package<V>> hashMap = new LinkedHashMap<Integer, new_package<V>>();
	private LocalDate timeStamp;
	File file;
	
	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = LocalDate.now();
	}
		
	public void enterNewParcel(new_package<V> parcel){
		hashMap.put(parcel.getKey(),(new_package<V>) parcel.getPackageNumber());
	}
	
	public LinkedHashMap<Integer,new_package<V>>getHashMap ()
    {
    	return this.hashMap;
    }
	
	public void removeElement(Integer key) 
	 {
		 hashMap.remove(key);
	 }
	 
	public void printHashMap ()
	 {
	    	System.out.println("Map:" + this.getHashMap());
	 }
		
	public void save(new_package<V> t) throws IOException 
	{ 
			try {
				saveFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void delete(new_package<V> t) throws IllegalArgumentException
		{
			if(hashMap.containsKey(t.getKey())) 
			{
				hashMap.remove(t.getKey());
				
				try {
					saveFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}

	public new_package<V> find(Integer id) throws IllegalArgumentException
	{
		return hashMap.get(id);	
	}
		
	public void saveFile() throws IOException 
	{
			FileWriter fstream;
		    BufferedWriter out;
		    fstream = new FileWriter(this.file);
		    out = new BufferedWriter(fstream);
		    Iterator<Entry<Integer, new_package<V>>> it = hashMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Entry<Integer, new_package<V>> pairs = it.next();
		        out.write(pairs + "\n");
		    }
		    out.close();
	}
}
