package com.ss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servlet1", urlPatterns = { "/servlet1" })
public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet1 </title>");
		out.println("</head>");
		out.println("<body>");
		
		String name = request.getParameter("name");
		out.println("<h1>Hello, "+name+" welcome to my website....</h1>");
		
		out.println("<h3><a href='servlet2'>Go to serrvlet 2</a></h1>");
		
		out.println("</body>");
		out.println("</html>");

		
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
