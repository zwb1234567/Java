package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.Userdao;

import vo.User;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();
		out.print("ok");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String UserName = request.getParameter("userName");
		String Password = request.getParameter("password");
		String code = request.getParameter("VerificationCode");
		
		
		HttpSession session = request.getSession();
		String vcode = (String) session.getAttribute("code");
		
		if(code.equals("0"))
		{
			code = vcode;
		}
		
		if(!code.equalsIgnoreCase(vcode))
		{
				out.write("验证码错误！");  
		}		
		else
		{
			Userdao dao = new Userdao();
			try {
				User user1 = dao.getUserById(UserName);
				if(user1 == null) //用户名不存在
				{ 
					
					//request.setAttribute("errorInfo","");
					//forwordPath = "/src/error.jsp";
					out.write("用户名不存在!"); 
				}
				else if(!(user1.getPassword().equals(Password))) //密码错误
				{
					//request.setAttribute("errorInfo","密码错误");
					//forwordPath = "/src/error.jsp";
					out.write("密码错误"); 
				}
				else //登陆成功
				{
					out.write("success");
					session.setAttribute("success",user1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
