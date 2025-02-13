package com.ss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "valid", urlPatterns = { "/valid" })
public class ValidateUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  HttpSession session =request.getSession(true);
		  String sessionId=session.getId();
		  out.println("<h1>Hey User Your Session ID is "+sessionId+"</h1>");
		  String u=request.getParameter("username");
		  String p=request.getParameter("password");
		  session.setAttribute("uname", u);
		  session.setAttribute("upass", p);
		  out.println("<a href='viewsession'>View Session Data</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
