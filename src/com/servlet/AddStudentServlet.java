package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.StudentDao;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {    //构造方法
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");//防止出现中文乱码
		
			
		// 获取注册信息
		String id = request.getParameter("A");
		String name = request.getParameter("B");
		// 获取注册信息
		String cls = request.getParameter("C");
		String age = request.getParameter("D");	// 获取注册信息
		String rooms = request.getParameter("E");

	
	//addStudent
		boolean a=StudentDao.addStudent(id,name,cls,age,rooms);
		

		if(a==true) {
			
			request.getSession().setAttribute("B1", "学生成功");
			response.sendRedirect("index.jsp");


		}else {
			request.getSession().setAttribute("B1", "添加失败");
			response.sendRedirect("index.jsp");
		}
	}
}
