package com.school.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.school.db.DB_Connection;
import com.school.model.Admin;
import com.school.model.Student;
public class Admin_Dao
{
	public boolean registerAdmin (Admin user)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			CallableStatement cs = con.prepareCall ("{? = call save_admin (?, ?, ?)}");
			cs.registerOutParameter (1, Types.BOOLEAN);
			cs.setInt (2, user.getId ());
			cs.setString (3, user.getUsername ());
			cs.setString (4, user.getPassword ());
			cs.execute ();
			return cs.getBoolean (1);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	public boolean registerStudent (Student user)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			CallableStatement cs = con.prepareCall ("{? = call save_student (?, ?, ?, ?)}");
			cs.registerOutParameter (1, Types.BOOLEAN);
			cs.setInt (2, user.getId ());
			cs.setString (3, user.getUsername ());
			cs.setInt (4, user.getAge ());
			cs.setString (5, user.getPassword ());
			cs.execute ();
			return cs.getBoolean (1);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	public Admin login (int id, String password)
	{
		Admin u = null;
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "select * from admin_info where id = ? and password = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			ps.setString (2, password);
			ResultSet rs = ps.executeQuery ();
			if (rs.next ())
			{
				u = new Admin ();
				u.setId (rs.getInt ("id"));
				u.setUsername (rs.getString ("username"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return u;
	}
	public List <Admin> getAllAdmin (String sort)
	{
        	List <Admin> admins = new ArrayList <> ();
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "SELECT id, username FROM admin_info";
			if ("id".equalsIgnoreCase (sort))
			{
				sql += " ORDER BY id";
			}
			else if ("username".equalsIgnoreCase (sort))
			{
				sql += " ORDER BY username";
			}
			PreparedStatement ps = con.prepareStatement (sql);
			ResultSet rs = ps.executeQuery ();
			while (rs.next ())
			{
				Admin a = new Admin ();
				a.setId (rs.getInt ("id"));
				a.setUsername(rs.getString ("username"));
				admins.add (a);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return admins;
	}
	public Admin getAdminById (int id)
	{
		Admin a = null;
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "SELECT id, username FROM admin_info WHERE id = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			ResultSet rs = ps.executeQuery ();
			if (rs.next ())
			{
				a = new Admin ();
				a.setId (rs.getInt ("id"));
				a.setUsername (rs.getString ("username"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return a;
	}
	public boolean updateAdmin (Admin admin)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "UPDATE admin_info SET username = ?, password = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setString (1, admin.getUsername ());
			ps.setString (2, admin.getPassword ());
			ps.setInt (3, admin.getId ());
			return ps.executeUpdate () > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	public boolean deleteAdmin (int id)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "DELETE FROM admin_info WHERE id = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			return ps.executeUpdate () > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	public Student getStudentById (int id)
	{
		Student s = null;
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "SELECT * FROM student_info WHERE id = ?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			ResultSet rs = ps.executeQuery ();
			if (rs.next ())
			{
				s = new Student ();
				s.setId (rs.getInt ("id"));
				s.setUsername (rs.getString ("username"));
				s.setAge (rs.getInt ("age"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return s;
	}
	public boolean updateStudent (Student s)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "UPDATE student_info SET username=?, age=?, password=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setString (1, s.getUsername ());
			ps.setInt (2, s.getAge ());
			ps.setString (3, s.getPassword ());
			ps.setInt (4, s.getId ());
			return ps.executeUpdate () > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	public boolean deleteStudent (int id)
	{
		try (Connection con = DB_Connection.getConnection ())
		{
			String sql = "DELETE FROM student_info WHERE id=?";
			PreparedStatement ps = con.prepareStatement (sql);
			ps.setInt (1, id);
			return ps.executeUpdate () > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			return false;
		}
	}
	
}