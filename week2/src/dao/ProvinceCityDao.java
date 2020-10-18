package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DataBaseConnection;
import vo.City;
import vo.Province;

public class ProvinceCityDao {
		private Connection con =null;
		private PreparedStatement pst = null;
		
		public ProvinceCityDao()
		{
			this.con =  new DataBaseConnection().getConnection();
		}
		
		public ArrayList<Province> queyrProvince() throws SQLException{
			ArrayList<Province> list = new ArrayList<Province>();
			ResultSet rs = null;
			String sql = "select id,name"
        		+ " from area limit 34";
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery(); 
				while(rs.next())
				{
					Province pro = new Province();
					pro.setProvinceId(rs.getString(1));
					pro.setProvinceName(rs.getString(2));
					list.add(pro);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			rs.close();
			pst.close();
			con.close();
			return list;
		}
		
		public ArrayList<City> queryCity(String parentid) throws SQLException{
			ArrayList<City> list = new ArrayList<City>();
			ResultSet rs = null;
			String sql = "select id,name,parentid"
	        		+ " from area where parentid = ? ";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, parentid);
				rs = pst.executeQuery();
				while(rs.next())
				{
					City city = new City();
					city.setCityId(rs.getString(1));
					city.setCityName(rs.getString(2));
					city.setParentId(rs.getString(3));
					list.add(city);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			rs.close();
			pst.close();
			con.close();
			return list;
		}
}
