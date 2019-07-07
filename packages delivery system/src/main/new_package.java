package main;

public class new_package<T> extends java.lang.Object implements java.io.Serializable
{
	private Integer key;
	private Boolean status;
	private T packageNumber;

	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public T getPackageNumber() {
		return packageNumber;
	}

	public void setPackageNumber(T packageNumber) {
		this.packageNumber = packageNumber;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
