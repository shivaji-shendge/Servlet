package com.ss;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Register Servlet is called");
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String contact= request.getParameter("contact");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NumberGuessingApp","root","root");
			if(conn!=null) {
				PreparedStatement stmt = conn.prepareStatement("insert into user values (?,?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, name);
				stmt.setString(3, email);
				stmt.setString(4, contact);
				stmt.setString(5, username);
				stmt.setString(6, password);
				int val = stmt.executeUpdate();
				if(val!=0) {
					RequestDispatcher r = request.getRequestDispatcher("index.html");
					r.forward(request, response);
				}
				else {
					RequestDispatcher r = request.getRequestDispatcher("index.html");
					r.include(request, response);
					out.println("Login Failed");
				}

			}
			else {
				out.println("Failed to connect with database");
			}
		}catch(Exception e) {
			out.println("Error is : "+e);
		}
	}

}
