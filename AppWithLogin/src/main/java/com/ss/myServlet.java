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


@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(" myServlet is called");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NumberGuessingApp","root","root");
			if(conn!=null) {
				PreparedStatement stmt = conn.prepareStatement("select * from user where username=? and password =?");
				stmt.setString(1, username);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					RequestDispatcher r = request.getRequestDispatcher("mainapp.html");
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
			out.println("Error is : "+ e );
			e.printStackTrace();
		}

	}

}
