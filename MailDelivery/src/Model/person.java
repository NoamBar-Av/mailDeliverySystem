package Model;

public class person {
	private String name;
	private Integer id;
	
	public person (String name,int id)
	{
		setName(name);
		setId(id);
	}
	public void setName(String name) {
		this.name = name;
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
	public int getQNUmber() {
		QueueNum Qnum=new QueueNum();
		return Qnum.getNunber();
	}
}