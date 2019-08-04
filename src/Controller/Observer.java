package Controller;

import java.beans.PropertyChangeEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;

import View.mainView;

public class Observer extends Observable
implements java.beans.PropertyChangeListener {
	public Observer() throws UnknownHostException, IOException
	{			  
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	} 
}
