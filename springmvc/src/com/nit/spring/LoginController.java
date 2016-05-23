package com.nit.spring;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.*;
import javax.servlet.http.*;


public class LoginController implements Controller
{
	private	 LoginModel   loginModel;
	public void setLoginModel(LoginModel lm)//setter-injection(LoginModel) takes place for this bean
	{
		loginModel=lm;
	}	
	public ModelAndView   handleRequest(HttpServletRequest req,HttpServletResponse res)
	{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");		
		
		String type=loginModel.validate(uname,pass);// calling  model  class  method
		
		if(type==null)
			return new ModelAndView("/Login.jsp?message=Invalid username/password");
		
		else if(type.equals("admin"))
			return new ModelAndView("/AdminHome.jsp");
		
		else
			return new ModelAndView("/UserHome.jsp");
	}
}





/*
Spring`s Web MVC framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale and theme resolution as well as support for upload files.

The default handler is a very simple Controller interface, just offering a 
ModelAndView  handleRequest(request,response) method.*/