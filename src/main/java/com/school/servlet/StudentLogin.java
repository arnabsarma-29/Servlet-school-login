package com.school.servlet;
import java.io.IOException;
import com.school.dao.Student_Dao;
import com.school.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/student_login")
public class StudentLogin extends HttpServlet
{
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher ("/views/student_login.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt (req.getParameter ("id"));
		String password = req.getParameter ("password");
		Student user = new Student_Dao().login (id, password);
		if (user != null)
		{
			HttpSession session = req.getSession ();
			session.setAttribute ("user", user);
			resp.sendRedirect (req.getContextPath () + "/views/student_details");
		}
		else
		{
			req.setAttribute ("error", "Invalid username or password");
			req.getRequestDispatcher ("/views/student_login.jsp").forward (req, resp);
		}
	}
}