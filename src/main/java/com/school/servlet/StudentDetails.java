package com.school.servlet;
import java.io.IOException;
import java.util.List;
import com.school.dao.Student_Dao;
import com.school.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/views/student_details")
public class StudentDetails extends HttpServlet
{
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession (false);
		if (session == null || session.getAttribute ("user") == null)
		{
			resp.sendRedirect (req.getContextPath () + "/views/student_login");
			return;
		}
		String sort = req.getParameter ("sort");
		Student_Dao dao = new Student_Dao ();
		List <Student> students = dao.getAllStudents (sort);
		req.setAttribute ("students", students);
		req.getRequestDispatcher ("/views/student_details.jsp").forward (req, resp);
	}
}