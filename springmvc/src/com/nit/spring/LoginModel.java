package com.nit.spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginModel 
{
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jt)   //setter 
	{
		jdbcTemplate=jt;
	}
	
	public String validate(String uname,String pass)
	{
		try
		{
			return (String)jdbcTemplate.queryForObject("select u_type from credentials where username=\'"+uname+"\' and passwd=\'"+pass+"\'",String.class);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
}
