package com.school.servlet;
import java.io.IOException;
import com.school.dao.Admin_Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/student_delete")
public class StudentDelete extends HttpServlet
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
		if (idParam == null || idParam.isEmpty ())
		{
			resp.sendRedirect (req.getContextPath () + "/views/student_details");
			return;
		}
		int id = Integer.parseInt (idParam);
		req.setAttribute ("studentId", id);
		req.getRequestDispatcher ("/views/student_delete.jsp").forward (req, resp);
	}
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String idParam = req.getParameter ("id");
		if (idParam != null)
		{
			int id = Integer.parseInt (idParam);
			new Admin_Dao ().deleteStudent (id);
		}
		resp.sendRedirect (req.getContextPath () + "/views/student_details");
	}
}