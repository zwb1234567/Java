package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DownloadDao;
import vo.Download;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/DownloadController.do")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();


		DownloadDao downloadDao = new DownloadDao();
		List<Download> downloads = null;
		try {
			downloads = downloadDao.findAll();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		/*
		 * for(int i=0;i<downloads.size();i++){
		 * 
		 * System.out.println(downloads.get(i).getId());
		 * 
		 * }
		 */
		session.setAttribute("downloads", downloads);
		request.getRequestDispatcher("/src/download.jsp").forward(request, response);
		//return 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
