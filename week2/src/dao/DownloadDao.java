package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Download;
import dbc.DataBaseConnection;

public class DownloadDao {
	private Connection con =null;
	private PreparedStatement pst = null;
	
	public DownloadDao(){
		this.con =  new DataBaseConnection().getConnection();
	}
	
	public Download finddownloadByid(int id) throws SQLException {
		ResultSet resultSet = null;
		Download download=null;
		 try {
	            

	            String sql = "select * from t_downloadList where id = ?";
	            pst = con.prepareStatement(sql);
	            pst.setInt(1,id);
	            resultSet = pst.executeQuery();

	            while (resultSet.next()) {
	                download=new Download();
	                
	                download.setId(resultSet.getInt("id"));
	                download.setName(resultSet.getString("name"));
	                download.setPath(resultSet.getString("path"));
	                download.setDescription(resultSet.getString("description"));
	                download.setSize(resultSet.getString("size"));
	                download.setStar(resultSet.getInt("star"));
	                download.setImage(resultSet.getString("image"));
	                return download;

	            }
	        } catch (Exception e) {
	        	System.out.println("异常");
	            e.printStackTrace();
	        } finally {
	        	resultSet.close();
	        	pst.close();
	            con.close();
	        }
		return null;
	}
	 
	 public List<Download> findAll() throws SQLException {
	        ResultSet resultSet = null;
	        List<Download>  downloads = new ArrayList<>();
	        try {
	            
	            String sql = "select * from t_downloadList";
	            pst = con.prepareStatement(sql);

	            resultSet = pst.executeQuery();
	            
	            while (resultSet.next()) {
	                Download download = new Download();
	                download.setId(resultSet.getInt(1));
	                download.setName(resultSet.getString(2));
	                download.setPath(resultSet.getString(3));
	                download.setDescription(resultSet.getString(4));
	                download.setSize(resultSet.getString(5));
	                download.setStar(resultSet.getInt(6));
	                download.setImage(resultSet.getString(7));
	                downloads.add(download);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            con.close();
	        }
	        return downloads;
	    }

}
