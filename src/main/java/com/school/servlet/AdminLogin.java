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
@WebServlet ("/views/admin_login")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getRequestDispatcher ("/views/admin_login.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt (req.getParameter ("id"));
		String password = req.getParameter ("password");
		Admin user = new Admin_Dao ().login (id, password);
		if (user != null)
		{
			HttpSession session = req.getSession ();
			session.setAttribute ("user", user);
			resp.sendRedirect (req.getContextPath () + "/views/admin_menu");
		}
		else
		{
			req.setAttribute ("error", "Invalid id or password");
			req.getRequestDispatcher ("/views/admin_login.jsp").forward (req, resp);
		}
	}
}