import java.io.*;

import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet  {
	//private static final long serialVersionUID = 1L;

	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("inside init of ShowServlet");
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema", "root", "root");
			ps = con.prepareStatement("select * from employee");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside service method of Show Servlet");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<h3> All Records </h3>");
		pw.println("<table align = centre>");
		
			
		try{
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			
			for(int i=1;i<=md.getColumnCount();i++)
				pw.print("<th>"+md.getColumnLabel(i)+"</th>");
			
			while(rs.next()){
				
				pw.print("<tr>");
				for(int i=1;i<=md.getColumnCount();i++)
					pw.print("<td>"+rs.getString(i)+"</td>");
				pw.print("</tr>");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		pw.println("</table>");		
		
		pw.println("<a href = Funtionality.html> back </a>");
		
	}

}
