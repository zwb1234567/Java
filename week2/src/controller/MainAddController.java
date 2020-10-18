package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CRUDMainDao;
import vo.CarPlace;
import vo.Cars;

/**
 * Servlet implementation class MainAddController
 */
@WebServlet("/MainAddController.do")
public class MainAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAddController() {
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
		PrintWriter out=response.getWriter();
		
		
		boolean result = false;
		String CNO = request.getParameter("CNO");
		//System.out.println(CNO);
		String CarNum = request.getParameter("CarNum");
		String CarPerson = request.getParameter("CarPerson");
		String CarType = request.getParameter("CarType");
		String CarDicretion = request.getParameter("CarDicretion");
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String Intime = df.format(date);
		if((CarNum == "" || CarNum == null)||(CarPerson == "" || CarPerson == null)||(CNO == "" || CNO == null))
		{
			out.write("warning");
		}
		else{
			Cars car = new Cars(CNO,CarPerson,Intime);
			CarPlace carplace = new CarPlace(CarNum,CNO,CarType,CarDicretion);
			CRUDMainDao dao = new CRUDMainDao();
			CRUDMainDao dao1 = new CRUDMainDao();
			try {				
				CarPlace cp = dao1.findCarPlaceByid(CarNum);
				Cars ocar = dao.findCarByid(CNO);
				if(ocar != null)
				{
					out.print("error0");
				}
				else if(cp != null)
				{
					out.print("error1");
				}
				else
				{
					CRUDMainDao dao2 = new CRUDMainDao();
					result = dao2.Insert(car, carplace);
					if(result){
						out.write("success");
					}else{
						out.write("error");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
