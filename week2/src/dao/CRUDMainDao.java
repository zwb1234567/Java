package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbc.DataBaseConnection;
import vo.CarPlace;
import vo.Cars;


public class CRUDMainDao {
	private Connection con =null;
	private PreparedStatement pst = null;
	public CRUDMainDao() {
		super();	
		this.con =  new DataBaseConnection().getConnection();
	}
	public Cars findCarByid(String cno) throws SQLException{
		String sql = "select * from t_cars where CNO = ?";	
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, cno);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				Cars car = new Cars();			
				car.setCNO(rs.getString(1));
				car.setCarPerson(rs.getString(2));
				car.setInTime(rs.getString(3));
				rs.close();
				pst.close();
				con.close();
				return car;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		pst.close();
		con.close();
		return null;
	}
	
	public CarPlace findCarPlaceByid(String carPlaceNum) throws SQLException{
		String sql = "select * from t_carplace where CarPlaceNum = ?";	
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, carPlaceNum);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				CarPlace cp = new CarPlace();			
				cp.setCarPlaceNum(rs.getString(1));
				cp.setCNO(rs.getString(2));
				cp.setType(rs.getString(3));
				cp.setDirection(rs.getString(4));
				rs.close();
				pst.close();
				con.close();
				return cp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		pst.close();
		con.close();
		return null;
	}
	
	public boolean Insert(Cars car,CarPlace carplace) throws SQLException{
		boolean result = false;		
		String sql1 = "insert into t_cars(CNO,CarPerson,InTime) values(?,?,?)";
		String sql2 = "insert into t_carplace(CarPlaceNum,CNO,Type,Direction) values(?,?,?,?)";
		String CNO = car.getCNO();
		String CarPerson = car.getCarPerson();
		String InTime = car.getInTime();
		String CarPlaceNum = carplace.getCarPlaceNum();
		String Type = carplace.getType();
		String Direction = carplace.getDirection();
		try {
			pst = con.prepareStatement(sql1);
			pst.setString(1, CNO);
			pst.setString(2, CarPerson);
			pst.setString(3, InTime);
			if(pst.executeUpdate() > 0)
			{
				pst = con.prepareStatement(sql2);
				pst.setString(1,CarPlaceNum);
				pst.setString(2,CNO);
				pst.setString(3,Type);
				pst.setString(4,Direction);
				if(pst.executeUpdate() > 0){
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pst.close();
		con.close();
		return result;
	}
	
	public boolean delete(String str) throws SQLException{
		boolean result = false;
		
		String sql1 = "delete from t_carplace where CNO = ? ";
		String sql2 = "delete from t_cars   where CNO = ? ";
		try {
			pst = con.prepareStatement(sql1);
			pst.setString(1, str);
			if(pst.executeUpdate() > 0)
			{
				pst = con.prepareStatement(sql2);
				pst.setString(1, str);
				if(pst.executeUpdate() > 0)
				{
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pst.close();
		con.close();
		return result;
	}
	
	public boolean update(Cars car,CarPlace carplace) throws SQLException{
		boolean result = false;
		String sql1 = "update t_cars  SET CarPerson = ?  where CNO = ? ";
		String sql2 = "update t_carplace SET CarPlaceNum = ?, Type = ?, Direction = ? "
				+ " where CNO = ? ";
		try {
			pst = con.prepareStatement(sql1);
			pst.setString(1, car.getCarPerson());
			pst.setString(2, car.getCNO());
			if(pst.executeUpdate() > 0)
			{
				pst = con.prepareStatement(sql2);
				pst.setString(1, carplace.getCarPlaceNum());
				pst.setString(2, carplace.getType());
				pst.setString(3, carplace.getDirection());
				pst.setString(4, carplace.getCNO());
				if(pst.executeUpdate() > 0)
				{
					result = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pst.close();
		con.close();
		return result;
	}
}
