package com.sujoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
	PreparedStatement psmt=null;
	Statement stmt=null;
	ResultSet res=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, un, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			String query="select * from students where Id=? and UserName=? and Password=?";
			con=DriverManager.getConnection(url, un, pwd);
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, username);
			psmt.setString(3, password);
			
			res=psmt.executeQuery();
			if(res.next()) {
				
				request.getRequestDispatcher("studentwelcomepage.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("invalidstudentlogin.html").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
