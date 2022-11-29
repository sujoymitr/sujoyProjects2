package com.sujoy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test1")
public class Test1 extends HttpServlet {
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
		String questions=request.getParameter("question");
		String option1=request.getParameter("option1");
		String option2=request.getParameter("option2");
		String option3=request.getParameter("option3");
		String option4=request.getParameter("option4");
		String correctans=request.getParameter("correctans");
		
		String query="insert into test1 values(?,?,?,?,?,?)";
		
		try {
			con=DriverManager.getConnection(url, un, pwd);
			psmt=con.prepareStatement(query);
			psmt.setString(1, questions);
			psmt.setString(2, option1);
			psmt.setString(3, option2);
			psmt.setString(4, option3);
			psmt.setString(5, option4);
			psmt.setString(6, correctans);
			psmt.executeUpdate();
			request.getRequestDispatcher("test1.html").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
