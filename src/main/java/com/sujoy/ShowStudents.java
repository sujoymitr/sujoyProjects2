package com.sujoy;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;


@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
	Statement stmt=null;
	ResultSet res=null;
	ArrayList<String> id=new ArrayList<String>();
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<String> userName=new ArrayList<String>();
	ArrayList<String> password=new ArrayList<String>();
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, un, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query="select * from students";
		try {
			con=DriverManager.getConnection(url, un, pwd);
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			while(res.next()) {
				id.add(res.getString(1));
				name.add(res.getString(2));
				userName.add(res.getString(3));
				password.add(res.getString(4));
			}
			
			HttpSession hs=request.getSession();
			hs.setAttribute("id", id);
			hs.setAttribute("name", name);
			hs.setAttribute("userName", userName);
			hs.setAttribute("password", password);
			
			request.getRequestDispatcher("showStudents.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
