package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbc.DataBaseConnection;
import vo.MainView;


public class MainViewDao {
	private Connection con =null;
	private PreparedStatement pst = null;
	
	public MainViewDao() {
		super();
		this.con =  new DataBaseConnection().getConnection();
	}
	
	public List<MainView> findAll(int num1,int num2,String CNO,String Cperson,String sortName,String sortOrder) throws SQLException {
		
        ResultSet resultSet = null;      
        List<MainView>  all = new ArrayList<>();
        String sql = "select a.CNO,b.CarPlaceNum,a.CarPerson,b.Type,a.InTime,b.Direction "
        		+ " from t_cars a,t_carPlace b where a.CNO = b.CNO ";
        if(CNO != null && CNO != "")
        {
        	sql += " And a.CNO like '%"+CNO+"%' ";
        	//System.out.print(sql);
        }if(Cperson !=null && Cperson!= ""){
        	sql += " And CarPerson like '%"+Cperson+"%' "; 
        }
        sql += " ORDER BY " + sortName + " " + sortOrder + " limit ?,? ";
        try {        	
            pst = con.prepareStatement(sql);
            pst.setInt(1,num1);
            pst.setInt(2,num2);           
            resultSet = pst.executeQuery();            
            while (resultSet.next()) {
            	MainView mv = new MainView();
            	mv.setCNO(resultSet.getString(1));
            	mv.setCarPlaceNum(resultSet.getString(2));
            	mv.setCarPerson(resultSet.getString(3));
            	mv.setType(resultSet.getString(4));
            	mv.setInTime(resultSet.getString(5));
            	mv.setDicretion(resultSet.getString(6));
                all.add(mv);
            }
            resultSet.close();
        	pst.close();
            con.close();
            return all;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	resultSet.close();
        	pst.close();
            con.close();
        }
        return all;
    }
	
	public int getCount(String CNO,String Cperson) throws SQLException{
		
        ResultSet resultSet = null;      
        int count = 0;
        String sql = "select a.CNO,b.CarPlaceNum,a.CarPerson,b.Type,a.InTime,b.Direction"
        		+ " from t_cars a,t_carPlace b where a.CNO = b.CNO ";
        if(CNO != null && CNO != "")
        {
        	sql += " And a.CNO like '%"+CNO+"%' ";
        	//System.out.print(sql);
        }if(Cperson !=null && Cperson!= ""){
        	sql += " And CarPerson like '%"+Cperson+"%' "; 
        }
        try {        	
            pst = con.prepareStatement(sql);         
            resultSet = pst.executeQuery();            
            while (resultSet.next()) {
            	count++;
            }
            resultSet.close();
        	pst.close();
            con.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	resultSet.close();
        	pst.close();
            con.close();
        }
        return count;
	}
	
	
}
