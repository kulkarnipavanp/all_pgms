package com.nit.spring;
import org.springframework.web.servlet.mvc.*;
import org.springframework.web.servlet.*;
import javax.servlet.http.*;

public class RegController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res)
	{
		int result1,result;
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		String type=req.getParameter("role");
		
		result1=regModel.check(uname,pass);
		
		if(result1==1)
			return new ModelAndView("/Login.jsp?message=username already exist");
		else
		{
			result=regModel.insert(uname,pass,type);		
			if(result==0)
			return new ModelAndView("/Login.jsp");
			else
			return new ModelAndView("/Message.jsp");
		}
	}
	public void setRegModel(RegModel lm)
	{
		regModel=lm;
	}
	private RegModel regModel;
}
