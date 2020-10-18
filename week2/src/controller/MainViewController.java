package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MainViewDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.MainView;

/**
 * Servlet implementation class MainViewController
 */
@WebServlet("/MainViewController.do")
public class MainViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MainView> list = null;
		MainViewDao dao = new MainViewDao();		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//String temp = request.getParameter("");
		String num1 = request.getParameter("offset");
		String num2 = request.getParameter("limit");
		String CNO = request.getParameter("CNO");
		String CarPerson = request.getParameter("CarPerson");
		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");
		
		int total = 0;
		//System.out.println(sortName);
		//System.out.println(sortOrder);
		try {
			list = dao.findAll(Integer.parseInt(num1),Integer.parseInt(num2),CNO,CarPerson,sortName,sortOrder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainViewDao dao1 = new MainViewDao();
		try {
			total = dao1.getCount(CNO,CarPerson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray rows = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        Date date = null;
        String time = "";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i = 0;i< list.size();i++)
        {
        	JSONObject obj = new JSONObject();
        	obj.put("CNO", list.get(i).getCNO());
        	obj.put("CarPlaceNum", list.get(i).getCarPlaceNum());
        	obj.put("CarPerson", list.get(i).getCarPerson());
        	obj.put("Type", list.get(i).getType());
        	try {
				date = fmt.parse(list.get(i).getInTime()); //转换成指定的日期形式
				time = fmt.format(date);   //转换成字符串
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	obj.put("InTime", time);
        	obj.put("Dicretion",list.get(i).getDicretion());
        	rows.add(obj);
        }
        jsonObj.put("rows", rows);
        jsonObj.put("total", total);
        out.print(jsonObj);
        out.flush(); 
        out.close(); 
        //out.write(jsonObj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
