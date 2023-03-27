package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/customersignup")
public class CoustomerSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CustomerDao customerDao = new CustomerDao();
	
	String email=req.getParameter("email");
	
	long mobile=Long.parseLong(req.getParameter("mobile"));
	
	
	
	Date date2=Date.valueOf(req.getParameter("date"));
//Period.between(date2.toLocalDate(), LocalDate.now());
int age = Period.between(date2.toLocalDate(), LocalDate.now()).getYears();
if(age<18)
{
	resp.getWriter().print("<h1> you have to be 18+ to create a bank account</h1>");
	req.getRequestDispatcher("Signup.html").include(req, resp);
}
	
//	resp.getWriter().print("<h1>"+date+" "+name+" "+mobile+" "+email+" "+password+" "+gender+"</h1>");


else{
	if(customerDao.check(mobile).isEmpty()&&customerDao.check(email).isEmpty()){
	Customer customer=new Customer();
	customer.setName(req.getParameter("name"));
	customer.setGender( req.getParameter("gender"));
	customer.setPassword(req.getParameter("password"));
	customer.setDate(date2);
	customer.setEmail(email);
	customer.setMobile(mobile);
	
	customerDao.insert(customer);
	Customer customer2=customerDao.check(email).get(0);
	resp.getWriter().print("<h1> Account Created Successfully</h1>");
	if(customer2.getGender().equals("male")){
		resp.getWriter().print("<h1>Hello sir</h1>");
	}
	else
		resp.getWriter().print("<h1>Hello maam</h1>");
		resp.getWriter().print("<h1>your customer id is : "+ customer2.getCust_id()+  "</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
	

	
	}
	else
	{
		resp.getWriter().print("<h1> Email or Phone Number already exists</h1>");
		req.getRequestDispatcher("Signup.html").include(req, resp);
	}
	
}
	
	}

}
