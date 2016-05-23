<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ob1" class="mypack.Products" scope="application">
</jsp:useBean>

<%
String pid=request.getParameter("pid");
String name=request.getParameter("name");
String qty=request.getParameter("qty");
String cost=request.getParameter("cost");
%>

<jsp:setProperty property="pid" name="ob1" value="<%=Integer.parseInt(pid)%>"/>
<jsp:setProperty property="name" name="ob1" value="<%=name %>"/>
<jsp:setProperty property="qty" name="ob1" value="<%=Integer.parseInt(qty) %>"/>
<jsp:setProperty property="cost" name="ob1" value="<%=Integer.parseInt(cost) %>"/>
<br>


Use Bean  object  values  are<br>

ProductID:<jsp:getProperty property="pid" name="ob1"/><br>
ProductName:<jsp:getProperty property="name" name="ob1"/><br>
Productqty:<jsp:getProperty property="qty" name="ob1"/><br>
ProductCost:<jsp:getProperty property="cost" name="ob1"/><br>

<br>Requested page</br>

<jsp:include page="requestpage.jsp"></jsp:include>


</body>
</html>