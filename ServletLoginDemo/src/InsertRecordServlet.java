import java.io.*;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/InsertRecordServlet")
public class InsertRecordServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	
	PreparedStatement ps;
       
   

	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("inside init of Insert Record");
		
		try{
			
			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);
			
			ps = con.prepareStatement("insert into Persons values(?,?,?,?,?)");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside service method of Insert Record");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Insert Record !! </h1>");
		
		String id = request.getParameter("pid_html");
		String first = request.getParameter("fname_html");
		String last = request.getParameter("lname_html");
		String addr = request.getParameter("address_html");
		String city = request.getParameter("city_html");
		
		try{
			
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, first);
			ps.setString(3, last);
			ps.setString(4, addr);
			ps.setString(5, city);
			
			int res = ps.executeUpdate();
			
			if(res>0)
				pw.println("<h3>record inserted successfully</h3>");
			
			pw.println("<a href = Funtionality.html> back </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
	}

}
