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

import dao.ProvinceCityDao;
import vo.City;
import vo.Province;

/**
 * Servlet implementation class QueryProvince
 */
@WebServlet("/QueryProvince.do")
public class QueryProvince extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProvince() {
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
		
		String province = request.getParameter("provinceid");//传省份的id过来
		String jsonstr = "";
		ProvinceCityDao dao = new ProvinceCityDao();
		if(province == "" || province == null) //省份还没选择,初始化省份
		{
			ArrayList<Province> provinceList = new ArrayList<Province>();
			try {
				provinceList = dao.queyrProvince();
				jsonstr = new Gson().toJson(provinceList);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}else{//选择了省份id，根据省份去选择城市
			ArrayList<City> CityList = new ArrayList<City>();
			try {
				CityList = dao.queryCity(province);
				jsonstr = new Gson().toJson(CityList);
			} catch (SQLException e) {

				e.printStackTrace();
			}			
		}
		out.print(jsonstr); //Json格式对象数组  [ {},{},{} ]
		out.flush();
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
