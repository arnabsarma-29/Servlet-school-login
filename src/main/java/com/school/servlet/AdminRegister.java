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
@WebServlet ("/views/admin_register")
public class AdminRegister extends HttpServlet
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
		req.getRequestDispatcher ("/views/admin_register.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Admin u = new Admin ();
		u.setId (Integer.parseInt (req.getParameter ("id")));
		u.setUsername (req.getParameter ("username"));
		u.setPassword (req.getParameter ("password"));
		boolean ok = new Admin_Dao ().registerAdmin (u);
		if (ok)
		{
			resp.sendRedirect (req.getContextPath () + "/views/admin_menu");
		}
		else
		{
			req.setAttribute ("error", "Registration failed");
			req.getRequestDispatcher ("/views/admin_register.jsp").forward (req, resp);
		}
	}
}