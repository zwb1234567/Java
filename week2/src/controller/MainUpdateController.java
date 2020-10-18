package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CRUDMainDao;
import vo.CarPlace;
import vo.Cars;

/**
 * Servlet implementation class MainUpdateController
 */
@WebServlet("/MainUpdateController.do")
public class MainUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainUpdateController() {
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
		
		String CNO = request.getParameter("CNO");
		String CarNum = request.getParameter("CarNum");
		String CarPerson = request.getParameter("CarPerson");
		String CarType = request.getParameter("CarType");
		String CarDicretion = request.getParameter("CarDicretion");
		String Intime = request.getParameter("intime");
/*		System.out.println(CNO);
		System.out.println(CarNum);
		System.out.println(CarPerson);
		System.out.println(CarType);
		System.out.println(CarDicretion);
		System.out.println(Intime);*/
		Cars car = new Cars(CNO,CarPerson,Intime);
		CarPlace carplace = new CarPlace(CarNum,CNO,CarType,CarDicretion);
		CRUDMainDao dao = new CRUDMainDao();
		CRUDMainDao dao1 = new CRUDMainDao();
		try {
			CarPlace cp = dao.findCarPlaceByid(CarNum);
			if(!(cp.getCNO().equals(CNO)))
			{
				out.print("error1");
			}
			else
			{
				if(dao1.update(car, carplace))
				{
					out.print("success");
				}
				else
				{
					out.print("error");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
