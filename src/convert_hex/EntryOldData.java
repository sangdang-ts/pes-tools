package convert_hex;

public class EntryOldData {
	private String name;
	private int nameSize;
	private int totalByte;
	private String firstByte;
	private String secondByte;

	public EntryOldData(String name, int nameSize, int totalByte, String firstByte, String secondByte) {
		super();
		this.name = name;
		this.nameSize = nameSize;
		this.totalByte = totalByte;
		this.firstByte = firstByte;
		this.secondByte = secondByte;
	}
	
	

	public EntryOldData() {
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNameSize() {
		return nameSize;
	}

	public void setNameSize(int nameSize) {
		this.nameSize = nameSize;
	}

	public int getTotalByte() {
		return totalByte;
	}

	public void setTotalByte(int totalByte) {
		this.totalByte = totalByte;
	}

	public String getFirstByte() {
		return firstByte;
	}

	public void setFirstByte(String firstByte) {
		this.firstByte = firstByte;
	}

	public String getSecondByte() {
		return secondByte;
	}

	public void setSecondByte(String secondByte) {
		this.secondByte = secondByte;
	}

	@Override
	public String toString() {
		return name + "\t" + nameSize + "\t" + totalByte + "\t" + firstByte + "\t" + secondByte + "\t";
	}

}
