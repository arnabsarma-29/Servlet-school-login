package com.school.db;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class DB_Connection
{
	private static HikariDataSource ds;
	private DB_Connection ()
	{

	}
	public static synchronized void initializeDataSource ()
	{
		if (ds == null)
		{
			HikariConfig config = new HikariConfig ();
			config.setJdbcUrl ("jdbc:postgresql://localhost:5432/servlet_school");
			config.setUsername ("postgres");
			config.setPassword ("123");
			config.setDriverClassName("org.postgresql.Driver");
			config.setMaximumPoolSize (10);
			config.setMinimumIdle (2);
			config.setIdleTimeout (30000);
			config.setPoolName ("Login_Hikari_CP");
			ds = new HikariDataSource (config);
		}
	}
	public static Connection getConnection () throws SQLException
	{
		if (ds == null)
		{
			initializeDataSource ();
		}
		return ds.getConnection ();
	}
	public static HikariDataSource getDataSource ()
	{
		if (ds == null)
		{
			initializeDataSource ();
		}
		return ds;
	}
}