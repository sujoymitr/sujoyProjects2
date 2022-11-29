package com.sujoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowResult")
public class ShowResult extends HttpServlet {
	String url="jdbc:mysql://localhost:3306/registration";
	String un="root";
	String pwd="root";
	Connection con=null;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String query="select * from scores1";
		String query1="select * from scores2";
		try {
			con=DriverManager.getConnection(url, un, pwd);
			stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(query);
			writer.println("<h3 style=\"color: red; text-align: center;\">Result for Test1 is:<h3>");
			writer.println("<table border='1' align=\"center\">\r\n"
					+ "			<tr>\r\n"
					+ "				<th>Name:</th>\r\n"
					+ "				<th>Scores:</th>\r\n"
					+ "			</tr>");
			while(res.next()) {
				writer.println("<tr>\r\n"
						+ "				<td>"+res.getString(1)+"</td>\r\n"
						+ "				<td>"+res.getInt(2)+"</td>\r\n"
						+ "			</tr>");
			}
			writer.println("</table>");
			
			
			ResultSet res1=stmt.executeQuery(query1);
			writer.println("<h3 style=\"color: red; text-align: center;\">Result for Test2 is:<h3>");
			writer.println("<table border='1' align=\"center\">\r\n"
					+ "			<tr>\r\n"
					+ "				<th>Name:</th>\r\n"
					+ "				<th>Scores:</th>\r\n"
					+ "			</tr>");
			while(res1.next()) {
				writer.println("<tr>\r\n"
						+ "				<td>"+res1.getString(1)+"</td>\r\n"
						+ "				<td>"+res1.getInt(2)+"</td>\r\n"
						+ "			</tr>");
			}
			writer.println("</table>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
