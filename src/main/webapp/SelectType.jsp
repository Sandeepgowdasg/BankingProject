<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Account Type</title>
</head>
<body>
<%Customer customer=(Customer)session.getAttribute("customer");

if(customer==null)
{
	response.getWriter().print("<h1>session Exprired</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{


%>
<h1>Hello <%=customer.getName() %></h1>
<h1>Select Type of Account</h1>
<form action="createbankaccount">
<input type="radio" name="banktype" value="saving"  required="required"><b>Saving</b><br>
<input type="radio" name="banktype" value="current"><b>current</b><br>
<button type="reset">cancel</button><button>Submit</button>


</form>
<%} %>

</body>
</html>