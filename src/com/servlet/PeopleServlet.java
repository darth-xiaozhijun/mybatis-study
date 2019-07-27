package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.People;
import com.service.PeopleService;
import com.service.impl.PeopleServiceImpl;
import com.utils.PageInfo;

/**
 * Servlet implementation class PeopleServlet
 */
@WebServlet("/people")
public class PeopleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PeopleService peopleService = new PeopleServiceImpl();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//第一次访问的验证,如果没有传递参数,设置默认值
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo<People> pi = peopleService.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", pi);
		req.getRequestDispatcher("page.jsp").forward(req, resp);
		
	}
}
