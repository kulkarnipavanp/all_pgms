

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
 * Servlet implementation class DeleteConfirmationServlet
 */
@WebServlet("/DeleteConfirmationServlet")
public class DeleteConfirmationServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	PreparedStatement ps;
 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	
		System.out.println("inside init of Delete Servlet");
		
		try{
			
			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);
			
			ps = con.prepareStatement("delete from Persons where Id = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1> Record Deleted !! </h1>");
		
		String pid = request.getParameter("pid_ds");
		
		try{
			
			ps.setString(1, pid);
			
			int res = ps.executeUpdate();
			
			
			if(res>0)
				pw.println("<h3>record deleted successfully</h3>");
			
			pw.println("<a href = DeleteRecord.html> Delete another record </a>");
			pw.println("<a href = Funtionality.html> Home </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}

	}

}
