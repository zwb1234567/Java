package dbc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
	private Connection con;
	private static String className;
	private static String url;
	private static String userName;
	private static String password;
	
	//静态代码，只会new的时候执行一次
	static{
		try{
		//读配置文件，加载驱动
		Properties pro = new Properties();
		InputStream is = DataBaseConnection.class.getResourceAsStream("/resources/jdbc.properties");
		pro.load(new InputStreamReader(is, "utf-8"));
		is.close();
		className = pro.getProperty("className");
		url = pro.getProperty("url");
		userName = pro.getProperty("userName");
		password = pro.getProperty("password");
		//加载驱动
		Class.forName(className);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public DataBaseConnection(){
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection  getConnection()
	{
		return this.con;
	}
	
	public  void close()
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
