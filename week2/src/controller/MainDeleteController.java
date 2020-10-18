package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dao.CRUDMainDao;
import vo.MainView;

/**
 * Servlet implementation class MainDeleteController
 */
@WebServlet("/MainDeleteController.do")
public class MainDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String str = request.getParameter("rows");
		//System.out.println(str);
		Gson gson = new Gson();
		@SuppressWarnings("deprecation")
		JsonParser parser = new JsonParser();
		@SuppressWarnings("deprecation")
		JsonArray Jarray = parser.parse(str).getAsJsonArray();//json对象数组	
		
		ArrayList<MainView> list = new ArrayList<MainView>();
		 
		for(JsonElement obj : Jarray ){//JsonElement对应json数组里的一个对象
			MainView one = gson.fromJson( obj , MainView.class); //转换成对象			
		    list.add(one);  
		}
		
		boolean flag = false;
		for(MainView mv : list)
		{
			CRUDMainDao dao = new CRUDMainDao();
			try {
				if(dao.delete(mv.getCNO()))
				{
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag)
		{
			out.print("success");
		}
		else{
			out.print("error");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
