package Driver;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import Controller.Observer;
import Model.Database;
import View.mainView;

public class driver {
	public static void main(String[] args) throws UnknownHostException, IOException, SQLException, ClassNotFoundException {
			Observer observer = new Observer();
			mainView view = new mainView();
			view.addPropertyChangeListener(observer);
	}
} 
 