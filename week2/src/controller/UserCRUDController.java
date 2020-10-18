package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import vo.User;

/**
 * Servlet implementation class UserCRUDController
 */
@WebServlet("/UserCRUDController.do")
public class UserCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCRUDController() {
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
		
		String userName = request.getParameter("userName");
		String chrName  = request.getParameter("chrName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Userdao dao = new Userdao();

		try {
			if(dao.getUserById(userName) != null)
			{
				out.print("0");
			}
			else
			{
				User newuser = new User();
				newuser.setUserName(userName);
				newuser.setChrName(chrName);
				newuser.setPassword(password);
				newuser.setProvince(province);
				newuser.setCity(city);
				newuser.setEmail(email);
				newuser.setRole("用户");
				Userdao dao1 = new Userdao();
				try {
					if(dao1.InsertUser(newuser))
					{
						out.print("1");
					}
					else
					{
						out.print("2");
					}
				} catch (SQLException e) {
					e.printStackTrace();
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
		doGet(request, response);
	}

}
