package com.school.model;
public class Student
{
	private int id;
	private String username;
	private int age;
	private String password;
	public int getId ()
	{
		return id;
	}
	public void setId (int id)
	{
		this.id = id;
	}
	public String getUsername ()
	{
		return username;
	}
	public void setUsername (String username)
	{
		if (username != null && !username.isEmpty ())
		{
			this.username = username;
		}
	}
	public int getAge ()
	{
		return age;
	}
	public void setAge (int age)
	{
		this.age = age;
	}
	public String getPassword ()
	{
		return password;
	}
	public void setPassword (String password)
	{
		if (password != null)
		{
			this.password = password;
		}
	}
}