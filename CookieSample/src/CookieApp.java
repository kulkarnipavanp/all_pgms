import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieApp")
public class CookieApp extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	PreparedStatement ps;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("inside init of login Servlet");

		try{

			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");

			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);


			ps = con.prepareStatement("select * from credentials where username = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException 
	{
		String username="",password="";
		try
		{
			PrintWriter p=res.getWriter();
			Cookie ck[]=request.getCookies();   //from  2nd  time  onwards
			try
			{
				username=ck[0].getValue();
				if(username==null)
					username="";

				password=ck[1].getValue();
				if(password==null)
					password="";
			}
			catch(Exception p1)
			{
				p1.printStackTrace();
			}

			p.println("<html><form action=CookieApp method=post>");
			p.println("<table align=center><tr>");
			p.println("<td>Username  </td><td><input type=text name=uname value="+username+"></td></tr>");
			p.println("<tr><td>Password </td><td><input type=password name=pwd value="+password+"></td></tr>");
			p.println("<tr><td></td><td><input type=checkbox name=c1 value=remember>Remember Me</td></tr>");
			p.println("<tr><td></td><td><input type=submit value=Submit></td></tr>");		
			p.println("</form></html>");
		}
		catch(Exception p)
		{
			p.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pwd");
		String choice;

		try
		{

			ps.setString(1, uname);
			//ps.executeQuery();

			ResultSet rs = ps.executeQuery();
			choice=request.getParameter("c1");

			Cookie ck1=new Cookie("username",uname);
			Cookie ck2=new Cookie("password",pass);			

			ck1.setMaxAge(60*60);//  sec-- hr
			ck2.setMaxAge(60*60);//sec

			response.addCookie(ck1);  //   send  the  cookie  into client  browser storage
			response.addCookie(ck2);
				
			
			if(rs.next()) {
				String p = rs.getString(2);

				if(p.equals(pass)){
 
					if(choice==null)
					{
						pw.print("login successful");
						pw.print("no cookies created");
					}
					else if(choice.equals("remember"))
					{
						pw.println("login successful");
						pw.println(" cookies created");
					}		

					else
						pw.println("no cookies but login success !!");
				}

				else{
					if(choice==null)
					{
						pw.println("Access denied.. ");
						pw.println("no cookies created");

					}
					else if(choice.equals("remember"))
					{
						pw.println("Access Denied");
						pw.println(" Please check cookies.. ");
					}		

					else
						pw.println("no cookies !!");
				}
			}
			
			else{
				
				pw.println("invalid username ! ");
			}

		}//end of try
		catch(Exception s)
		{
			s.printStackTrace();
		}		
	}
}
