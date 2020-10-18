package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DownloadDao;
import vo.Download;


/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paString=null;
		String id = request.getParameter("button");
		//System.out.println(id);
		
		Download dl = new Download();
		DownloadDao downloadDao = new DownloadDao();
		try {
			dl = downloadDao.finddownloadByid(Integer.parseInt(id));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//调用对象的get方法
		  paString = dl.getPath();
		  //System.out.println(dl); 
		
		  String path=request.getServletContext().getRealPath(paString); 
		  
		  String fileName=path.substring(path.lastIndexOf("\\")+1); 
		  
		  response.setHeader("content-disposition","attachment;filename=" +
		  URLEncoder.encode(fileName,"UTF-8") );
		  
		  InputStream in = new FileInputStream(path); 
		  int len =0;
		  
		  byte[] buffer = new byte[1024];
		  
		  ServletOutputStream out= response.getOutputStream(); while
		  ((len=in.read(buffer))!=-1) { out.write(buffer,0,len); }
		  in.close();
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
