package vo;

public class CarPlace {
	private String CarPlaceNum;
	private String CNO;
	private String Type;
	private String Direction;
	public String getCarPlaceNum() {
		return CarPlaceNum;
	}
	public void setCarPlaceNum(String carPlaceNum) {
		CarPlaceNum = carPlaceNum;
	}
	public String getCNO() {
		return CNO;
	}
	public void setCNO(String cNO) {
		CNO = cNO;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
	public CarPlace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarPlace(String carPlaceNum, String cNO, String type, String direction) {
		super();
		CarPlaceNum = carPlaceNum;
		CNO = cNO;
		Type = type;
		Direction = direction;
	}
	
}
