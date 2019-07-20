package Model;

import java.sql.Timestamp;
import java.util.Random;

public class QueueNum 
{
	private int nunber;
	private Timestamp timestamp ;
	private long time;
	
	public QueueNum() 
	{
		Random rand = new Random();
		int Qnum = rand.nextInt(50);
		setNunber(Qnum);
	}
	public void setTime() {
		this.time=timestamp.getTime();
	}
	public long getTime() {
		return time;
	}
	public int getNunber() {
		return nunber;
	}
	public void setNunber(int nunber) {
		this.nunber = nunber;
	}

	
}

