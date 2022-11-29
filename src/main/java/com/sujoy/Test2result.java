package com.sujoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test2result")
public class Test2result extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
	Statement stmt=null;
	ResultSet res=null;
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
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		int marks=0;
		try {
			String query="select * from test2";
			con=DriverManager.getConnection(url, un, pwd);
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			int i = 0;
			String name=request.getParameter("name");
			while(res.next()) {
				if(res.getString(6).equals(request.getParameter("answer"+i+""))) {
					marks++;
				}
				i++;
			}
			String query1="insert into scores2 values(?,?)";
			psmt=con.prepareStatement(query1);
			psmt.setString(1, name);
			psmt.setInt(2, marks);
			psmt.executeUpdate();
			request.getRequestDispatcher("examsubmitted.html").forward(request, response);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}

}
