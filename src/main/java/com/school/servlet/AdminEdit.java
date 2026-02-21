package com.school.servlet;
import java.io.IOException;
import com.school.dao.Admin_Dao;
import com.school.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/admin_edit")
public class AdminEdit extends HttpServlet
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
		int id = Integer.parseInt (req.getParameter ("id"));
		Admin admin = new Admin_Dao ().getAdminById (id);
		if (admin == null)
		{
			resp.sendRedirect(req.getContextPath() + "/views/admin_details");
			return;
		}
		req.setAttribute("admin", admin);
		req.getRequestDispatcher("/views/admin_edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Admin a = new Admin ();
		a.setId (Integer.parseInt(req.getParameter ("id")));
		a.setUsername (req.getParameter ("username"));
		a.setPassword (req.getParameter ("password"));
		new Admin_Dao ().updateAdmin (a);
		resp.sendRedirect (req.getContextPath () + "/views/admin_details");
	}
}