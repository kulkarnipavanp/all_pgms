<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ob1" class="mypack.Products" scope="application"></jsp:useBean>

ProductID:<jsp:getProperty property="pid" name="ob1"/><br>
ProductName:<jsp:getProperty property="name" name="ob1"/><br>
Productqty:<jsp:getProperty property="qty" name="ob1"/><br>
ProductCost:<jsp:getProperty property="cost" name="ob1"/><br>

<a href="sessionpage.jsp"> Next page</a>

</body>
</html>