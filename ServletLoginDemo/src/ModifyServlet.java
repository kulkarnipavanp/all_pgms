

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

		
	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init of Modify Servlet");
		
		try{
			
			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);
			ps = con.prepareStatement("update Persons set Id=?, FirstName=?, LastName=?, Address=?, City=? where Id = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
  
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside service method of Modify Servlet");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1> Record Updated !! </h1>");
		
		String pid = request.getParameter("pid_fs");
		String first = request.getParameter("fname_fs");
		String last = request.getParameter("lname_fs");
		String addr = request.getParameter("address_fs");
		String city = request.getParameter("city_fs");
		
				
		try{
			
			ps.setString(1, pid);
			ps.setString(2, first);
			ps.setString(3, last);
			ps.setString(4, addr);
			ps.setString(5, city);
			ps.setString(6, pid);
			
			int res = ps.executeUpdate();
			
			if(res>0)
				pw.println("<h3>record inserted successfully</h3>");
			
			pw.println("<a href = Fetch.html> Change another record </a>");
			pw.println("<a href = Funtionality.html> Home </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
	}

}
