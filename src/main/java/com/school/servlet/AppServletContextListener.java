package com.school.servlet;
import com.school.db.DB_Connection;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.ServletContextListener;
@WebListener
public class AppServletContextListener implements ServletContextListener
{
	@Override
	public void contextInitialized (ServletContextEvent sce)
	{
		try
		{
			DB_Connection.initializeDataSource ();
			System.out.println ("HikariCP pool initialized successfully");
		}
		catch (Exception e)
		{
			System.err.println ("Failed to initialize HikariCP pool");
			e.printStackTrace ();
		}
	}
	@Override
	public void contextDestroyed (ServletContextEvent sce)
	{
		try
		{
			HikariDataSource ds = DB_Connection.getDataSource ();
			if (ds != null && !ds.isClosed ())
			{
				ds.close ();
				System.out.println ("HikariCP pool closed.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
	}
}