import java.io.*;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/InsertRecordServlet")
public class InsertRecordServlet {
	
	PreparedStatement ps;
       
   

	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("inside init of Insert Record");
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_demo", "root", "root");
			ps = con.prepareStatement("insert into employee values(?, ?,?)");
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
		
		String eid = request.getParameter("eid_html");
		String first = request.getParameter("fname_html");
		String last = request.getParameter("lname_html");
		
		try{
			ps.setInt(1, Integer.parseInt(eid));
			ps.setString(2, first);
			ps.setString(3, last);
			
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
