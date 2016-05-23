<html>
  <head>
    <title>My JSP Login.jsp starting page</title>
  </head>
  
  <body bgcolor="cyan">
<h3>
<%  String mes=request.getParameter("message");
	if(mes!=null)
	{
		out.print("<h3 align=center><font color=red>"+mes+"</font></h3>");
	}
%></h3>
<h3><u>Login Form</u></h3>

	<form action="login.do">
	<table>
	<tr><td>Username</td><td><input type=text name=uname></td></tr>
	<tr><td>Password</td><td><input type=password name=pass></td></tr>
	<tr><td></td><td><input type=submit value="Existing User"></td></tr>
	</table>
	</form>
<br>
<h3><u>Register form</u></h3>
<form action="reg.do">
	<table>
	<tr><td>Username</td><td><input type=text name=uname></td></tr>
	<tr><td>Password</td><td><input type=password name=pass></td></tr>
	<tr><td>Role</td><td><input type=text name=role></td></tr>
	<tr><td></td><td><input type=submit value="New User">
	</td></tr>
	</table>
	</form>
  </body>
</html>