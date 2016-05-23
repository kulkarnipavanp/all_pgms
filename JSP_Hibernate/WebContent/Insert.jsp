<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!Connection con = null;
	PreparedStatement pst = null;%>

	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema", "root", "root");
		pst = con.prepareStatement("insert into Persons values(?,?,?,?,?)");

		String id = request.getParameter("pid_html");
		String fname = request.getParameter("fname_html");
		String lname = request.getParameter("lname_html");
		String address = request.getParameter("address_html");
		String city = request.getParameter("city_html");

		pst.setString(1, id);
		pst.setString(2, fname);
		pst.setString(3, lname);
		pst.setString(4, address);
		pst.setString(5, city);
		
		int result = pst.executeUpdate();

		if (result > 0)
			out.print("<h3>Record Inserted successfully</h3><a href='welcome.html'> BACK </a>");
	%>
</body>
</html>