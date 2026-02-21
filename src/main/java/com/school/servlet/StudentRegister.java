package com.school.servlet;
import java.io.IOException;
import com.school.dao.Admin_Dao;
import com.school.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/student_register")
public class StudentRegister extends HttpServlet
{
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession (false);
		if (session == null || session.getAttribute ("user") == null)
		{
			resp.sendRedirect (req.getContextPath () + "/views/admin_login");
			return;
		}
		req.getRequestDispatcher ("/views/student_register.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Student u = new Student ();
		u.setId (Integer.parseInt (req.getParameter ("id")));
		u.setUsername (req.getParameter ("username"));
		u.setAge (Integer.parseInt (req.getParameter ("age")));
		u.setPassword (req.getParameter ("password"));
		boolean ok = new Admin_Dao ().registerStudent (u);
		if (ok)
		{
			resp.sendRedirect (req.getContextPath () + "/views/admin_menu");
		}
		else
		{
			req.setAttribute ("error", "Registration failed");
			req.getRequestDispatcher ("/views/student_register.jsp").forward (req, resp);
		}
	}
}