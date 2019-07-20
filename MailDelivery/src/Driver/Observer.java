package Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

import View.mainView;

public class Observer
implements java.beans.PropertyChangeListener {
	private String jsonAsString;
	private String message;
	public Observer() throws UnknownHostException, IOException
	{			  
	} 
	public void propertyChange(java.beans.PropertyChangeEvent evt) // this function called from the view. 
	{
	//	CahceUnitClient cl = new CahceUnitClient();
		mainView view = (mainView)evt.getSource();
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("show")) {
//				message = cl.send("showStatistics"); // The request now sending to the 'send' method -> and then to the server
		}
		else {
			String filePath = (String) evt.getNewValue();
			try {
				jsonAsString = new String(Files.readAllBytes(Paths.get(filePath)));
			} catch (IOException e) {
				e.printStackTrace();
			}
	//			message = cl.send(jsonAsString); // The request now sending to the 'send' method -> and then to the server
		}
	//	view.updateUIData(message); // The message from the server is now delivered to the "view", were the user could see it
		
		
	}
}
