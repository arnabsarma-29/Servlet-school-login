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
@WebServlet ("/views/student_edit")
public class StudentEdit extends HttpServlet
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
		String idParam = req.getParameter ("id");
		if (idParam == null)
		{
			resp.sendRedirect (req.getContextPath () + "/views/student_details");
			return;
		}
		int id = Integer.parseInt (idParam);
		Student student = new Admin_Dao ().getStudentById (id);
		if (student == null)
		{
			resp.sendRedirect (req.getContextPath () + "/views/student_details");
			return;
		}
		req.setAttribute ("student", student);
		req.getRequestDispatcher ("/views/student_edit.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession (false);
		if (session == null || session.getAttribute ("user") == null)
		{
			resp.sendRedirect (req.getContextPath () + "/views/admin_login");
			return;
		}
		int id = Integer.parseInt (req.getParameter ("id"));
		String username = req.getParameter ("username");
		int age = Integer.parseInt (req.getParameter ("age"));
		String password = req.getParameter ("password");
		Student s = new Student ();
		s.setId (id);
		s.setUsername (username);
		s.setAge (age);
		s.setPassword (password);
		Admin_Dao dao = new Admin_Dao ();
		dao.updateStudent (s);
		resp.sendRedirect (req.getContextPath () + "/views/student_details");
	}
}