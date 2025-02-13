package com.ss;

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

@WebServlet("/MyServLet")
public class MyServLet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		
		out.println("MyServlet doGet Method is called and data is retrived");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRecords","root","root");
			if(conn!=null) {
				PreparedStatement stmt = conn.prepareStatement("insert into student (name,email,contact) values (?,?,?)");
				stmt.setString(1,name );
				stmt.setString(2, email);
				stmt.setString(3,contact );
				
				int val = stmt.executeUpdate();
				if(val!=0) {
					out.println("Registration successful");
				}
				else {
					out.println("Data not inserted");
				}
			}
			else {
				out.println("Some issue to connectt with database");
			}
			
		}
		catch(Exception ex) {
			out.println("Error is "+ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
