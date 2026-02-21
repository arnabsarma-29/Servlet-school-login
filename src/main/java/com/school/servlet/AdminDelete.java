package com.school.servlet;
import java.io.IOException;
import com.school.dao.Admin_Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/admin_delete")
public class AdminDelete extends HttpServlet
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
		req.setAttribute ("adminId", id);
		req.getRequestDispatcher ("/views/admin_delete.jsp").forward (req, resp);
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt (req.getParameter ("id"));
		new Admin_Dao ().deleteAdmin (id);
		resp.sendRedirect (req.getContextPath () + "/views/admin_details");
	}
}