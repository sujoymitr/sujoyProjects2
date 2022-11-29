package com.sujoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Test2exam")
public class Test2exam extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
	Statement stmt=null;
	ResultSet res=null;
	ArrayList<String> question=new ArrayList<String>();
	ArrayList<String> option1=new ArrayList<String>();
	ArrayList<String> option2=new ArrayList<String>();
	ArrayList<String> option3=new ArrayList<String>();
	ArrayList<String> option4=new ArrayList<String>();
	ArrayList<String> currectAns=new ArrayList<String>();
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
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		try {
			String query="select * from test2";
			con=DriverManager.getConnection(url, un, pwd);
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			while(res.next()) {
				question.add(res.getString(1));
				option1.add(res.getString(2));
				option2.add(res.getString(3));
				option3.add(res.getString(4));
				option4.add(res.getString(5));
				currectAns.add(res.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession hs1=request.getSession();
		
		hs1.setAttribute("question", question);
		hs1.setAttribute("option1", option1);
		hs1.setAttribute("option2", option2);
		hs1.setAttribute("option3", option3);
		hs1.setAttribute("option4", option4);
		hs1.setAttribute("currectAns", currectAns);
		
		request.getRequestDispatcher("/Test2.jsp").forward(request, response);
	}

	

}
