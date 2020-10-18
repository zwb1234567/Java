package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbc.DataBaseConnection;
import vo.User;

public class Userdao {
	
	private Connection con =null;
	private PreparedStatement pst = null;
	
	public Userdao()
	{
		this.con =  new DataBaseConnection().getConnection();
	}
	
	
	
	public User getUserById(String id) throws SQLException {
		String sql = "select * from Users where userName = ?";	
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			 ResultSet rs = pst.executeQuery();		
			if(rs.next())
			{	
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setChrName(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setProvince(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setEmail(rs.getString(7));
	        	rs.close();
	        	pst.close();
	            con.close();
				return user;
			}
			else{
				rs.close();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}  
    	pst.close();
        con.close();
		return null;
	}
	
	public boolean InsertUser(User user) throws SQLException{
		boolean result = false;
		String sql = "insert into users(userName,password,chrName,role,province,city,email)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getChrName());
			pst.setString(4, user.getRole());
			pst.setString(5, user.getProvince());
			pst.setString(6, user.getCity());
			pst.setString(7, user.getEmail());
			if(pst.executeUpdate()>0)
			{
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pst.close();
		con.close();
		return result;
	}
}
