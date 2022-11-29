package com.sujoy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupClass")
public class SignupClass extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
	PreparedStatement psmt=null;
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
		String FirstName=request.getParameter("fn");
		String LastName=request.getParameter("ln");
		String Gender=request.getParameter("gender");
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		
		String query="insert into signup values(?,?,?,?,?)";
		try {
			con=DriverManager.getConnection(url, un, pwd);
			psmt=con.prepareStatement(query);
			psmt.setString(1, FirstName);
			psmt.setString(2, LastName);
			psmt.setString(3, Gender);
			psmt.setString(4, Email);
			psmt.setString(5, Password);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/signupconfirm.html").forward(request, response);
		
	}

}
