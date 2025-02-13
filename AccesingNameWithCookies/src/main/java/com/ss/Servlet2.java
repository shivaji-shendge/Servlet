package com.ss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servlet2", urlPatterns = { "/servlet2" })
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet 2 </title>");
		out.println("</head>");
		out.println("<body>");
		
		//getting all the cookies
		Cookie[] cookies = request.getCookies();
		boolean f= false;
		String name = null;
		
		if(cookies==null) {
			out.println("<h1>You are new user go to home page and submit your name ");
			return;
		}
		else {
			for(Cookie c: cookies) {
				String tname= c.getName();
				if(tname.equals("username")) {
					f=true;
					 name=c.getValue();
				}
			}
		}
		if(f) {
			out.println("<h1>Hello, "+name+" welcome back to my website....</h1>");
			
			out.println("<h2>Thank You!</h2>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
