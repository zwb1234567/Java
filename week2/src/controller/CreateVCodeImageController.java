package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImg;

/**
 * Servlet implementation class CreateVCodeImageController
 */
@WebServlet("/CreateVCodeImageController.do")
public class CreateVCodeImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateVCodeImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//生成四位长度 的随机字符串
		CreateImg CreateImage = new CreateImg();
		String vcode = CreateImage.CreateCode();
		
		//将生成的四位字符串保存在session范围内
		HttpSession  session = request.getSession();
		session.setAttribute("code", vcode);
		
		response.setContentType("image/jpg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//生成图片
		BufferedImage image = CreateImage.createImage(vcode);
		
		//返回给客户端
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
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
