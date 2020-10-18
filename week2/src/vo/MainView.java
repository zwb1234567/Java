package vo;



public class MainView {
	private String CNO;
	private String CarPlaceNum;
	private String CarPerson;
	private String Type;
	private String InTime;
	private String Dicretion;
	public String getDicretion() {
		return Dicretion;
	}
	public void setDicretion(String dicretion) {
		this.Dicretion = dicretion;
	}
	public MainView() {
		super();
	}
	public String getCNO() {
		return CNO;
	}
	public void setCNO(String cNO) {
		CNO = cNO;
	}
	public String getCarPlaceNum() {
		return CarPlaceNum;
	}
	public void setCarPlaceNum(String carPlaceNum) {
		CarPlaceNum = carPlaceNum;
	}
	public String getCarPerson() {
		return CarPerson;
	}
	public void setCarPerson(String carPerson) {
		CarPerson = carPerson;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getInTime() {
		return InTime;
	}
	public void setInTime(String inTime) {
		InTime = inTime;
	}
	
}
