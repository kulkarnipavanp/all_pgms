

import java.io.*;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	PreparedStatement ps;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
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

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside service method of login Servlet");
		
		
		try {
			
			response.setContentType("text/html");
			
			PrintWriter pw = response.getWriter();
			
			
			String uname = request.getParameter("uname_h");
			String passwd = request.getParameter("passwd_h");
						
			ps.setString(1, uname);
			//ps.executeQuery();
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				String p = rs.getString(2);
			
			
			if(p.equals(passwd)){
				pw.println("Login Success !!");
				pw.println("<a href = Funtionality.html> Functionalities </a>");
				
				
			}
			
			else
				pw.println("Try Again");
			}
			
			else{
				
				
				pw.println("invalid data");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
