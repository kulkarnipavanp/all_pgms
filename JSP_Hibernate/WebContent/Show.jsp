
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Tables</title>
</head>
<body>

<%!
Connection con = null;
PreparedStatement pst = null;
%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema","root","root");
pst=con.prepareStatement("select * from Persons");

ResultSet rs = pst.executeQuery();
ResultSetMetaData md = rs.getMetaData();
out.print("<table border=5 align=centre>");
for(int i=1; i<=md.getColumnCount();i++)
	out.print("<th>"+md.getColumnName(i)+"</th>");

while(rs.next())
{
	out.print("<tr>");
	for(int i=1; i<=md.getColumnCount();i++)
			out.print("<td>"+rs.getString(i)+"</td>");
	
	out.print("</tr>");
}

out.print("</TABLE>");
out.print("<a href='welcome.html'> BACK </a>");

%>
</body>
</html>