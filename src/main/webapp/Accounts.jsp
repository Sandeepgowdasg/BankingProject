<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
</head>
<body>
<% List<BankAccount> list=(List<BankAccount>)request.getAttribute("list");
if(list.isEmpty())
{
%>
<h1>NO Active Accounts Found</h1>
<% } else{ %>
<h1>Select Bank Account</h1>
<%for(BankAccount account:list) {%>
<a href="setaccount?acno=<%=account.getAcno()%>"><button><%= account.getAcno() %></button></a><br><br>
<% }  %>
<% }  %>
<br>
<a href="CustomerHome.html"><button>Back</button></a>
</body>
</html>