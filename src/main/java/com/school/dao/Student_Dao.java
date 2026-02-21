package com.school.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.school.db.DB_Connection;
import com.school.model.Student;
public class Student_Dao
{
	public Student login (int id, String password)
	{
		Student u = null;
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "select * from student_info where id = ? and password = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			ps.setString (2, password);
			ResultSet rs = ps.executeQuery ();
			if (rs.next ())
			{
				u = new Student ();
				u.setId (rs.getInt ("id"));
				u.setAge (rs.getInt ("age"));
				u.setUsername (rs.getString ("username"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return u;
	}
	public List <Student> getAllStudents (String sortBy)
	{
		List <Student> list = new ArrayList <> ();
        	String orderBy = "id";
        	if ("username".equals (sortBy)) orderBy = "username";
        	if ("age".equals (sortBy)) orderBy = "age";
        	String sql = "SELECT id, username, age FROM student_info ORDER BY " + orderBy;
		try (Connection con = DB_Connection.getConnection ();
		PreparedStatement ps = con.prepareStatement (sql);
		ResultSet rs = ps.executeQuery ())
		{
			while (rs.next ())
			{
				Student s = new Student ();
                		s.setId (rs.getInt ("id"));
                		s.setUsername (rs.getString ("username"));
                		s.setAge (rs.getInt ("age"));
                		list.add (s);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return list;
	}
}
