package com.ss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "viewsession", urlPatterns = { "/viewsession" })
public class ViewSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  HttpSession session=request.getSession();
		  String username=session.getAttribute("uname").toString();
		  String password=session.getAttribute("upass").toString();
		  out.println("<h1>Data From Session</h1>");
		  out.println("<h1>Username is "+username+"</h1>");
		  out.println("<h1>Password is "+password+"</h1>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
