package Driver;

import java.io.IOException;
import java.net.UnknownHostException;

import View.mainView;

public class driver {
	public static void main(String[] args) throws UnknownHostException, IOException {
			Observer observer = new Observer();
			mainView view = new mainView();
			view.addPropertyChangeListener(observer);
			view.start();
	}
} 
 