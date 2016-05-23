

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
  
	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("inside init Delete Servlet ");
		
		try{
			
			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);
			ps = con.prepareStatement("select *  from Persons where id = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
System.out.println("inside service method of Delete Servlet");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h3>Record : </h3>");
		
		String id = request.getParameter("pid_dh");
		
		try{
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				pw.println("<form action = DeleteConfirmationServlet align=centre method= post><table>");
				pw.println("<tr><td>ID</td><td><input type=text name=pid_ds value="+rs.getInt(1)+"></td></tr>");
				pw.println("<tr><td>First Name</td><td><input type=text name=fname_ds value="+rs.getString(2)+"></td></tr>");
				pw.println("<tr><td>Last Name</td><td><input type=text name=lname_ds value="+rs.getString(3)+"></td></tr>");
				pw.println("<tr><td>Address </td><td><input type=text name=address_ds value="+rs.getString(4)+"></td></tr>");
				pw.println("<tr><td>City </td><td><input type=text name=city_ds value="+rs.getString(5)+"></td></tr>");
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				
				pw.println("<tr><td>Click to Delete</td><td><input type=submit name=DELETE></td></tr>");
				pw.println("</table>");
				pw.println("</form>");
			}
			else
				pw.println("<h3>Record Not Found</h3>");
			
			
			pw.println("<a href = Fetch.html> back </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		
		
	}

}
