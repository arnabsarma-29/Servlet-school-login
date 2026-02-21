package com.school.servlet;
import java.io.IOException;
import java.util.List;
import com.school.dao.Admin_Dao;
import com.school.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/admin_details")
public class AdminDetails extends HttpServlet
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
		String sort = req.getParameter ("sort");
		Admin_Dao dao = new Admin_Dao ();
		List <Admin> admin = dao.getAllAdmin (sort);
		req.setAttribute ("admin", admin);
		req.getRequestDispatcher ("/views/admin_details.jsp").forward (req, resp);
	}
}