package vo;

public class Cars {
	private String CNO;
	private String CarPerson;
	private String InTime;
	public String getCNO() {
		return CNO;
	}
	public void setCNO(String cNO) {
		CNO = cNO;
	}
	public String getCarPerson() {
		return CarPerson;
	}
	public void setCarPerson(String carPerson) {
		CarPerson = carPerson;
	}
	public String getInTime() {
		return InTime;
	}
	public void setInTime(String inTime) {
		InTime = inTime;
	}
	public Cars() {
		super();
	}
	public Cars(String cNO, String carPerson, String inTime) {
		super();
		CNO = cNO;
		CarPerson = carPerson;
		InTime = inTime;
	}
	
}
