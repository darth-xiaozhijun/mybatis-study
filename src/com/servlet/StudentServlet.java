package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.StudentPageInfo;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private StudentService stuService = new StudentServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		if (sname != null && !sname.equals(""))
			sname = new String(sname.getBytes("iso-8859-1"), "utf-8");
		String tname = req.getParameter("tname");
		if (tname != null && !tname.equals(""))
			tname = new String(tname.getBytes("iso-8859-1"), "utf-8");
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");
		StudentPageInfo pi = stuService.showPage(sname, tname, pageSize, pageNumber);
		System.out.println(pi);
		req.setAttribute("pageinfo", pi);
		req.getRequestDispatcher("student.jsp").forward(req, resp);
	}

}
