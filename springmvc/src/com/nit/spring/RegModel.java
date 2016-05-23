package com.nit.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
public class RegModel 
{
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jt)
	{
		jdbcTemplate=jt;
	}
	public int check(String uname,String pass)//  validation 
	{
		int x=0;
		try
		{
		List lt1 = jdbcTemplate.queryForList("select * from userdetails where uname=\'"+uname+"\'");
		Iterator i = lt1.iterator();
		if(i.hasNext())
		{
			x=1;
		}
		return x;
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	public int insert(String uname,String pass,String role)
	{
		try
		{
			return(jdbcTemplate.update("insert into userdetails values(\'"+uname+"\',\'"+pass+"\',\'"+role+"\')"));
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
