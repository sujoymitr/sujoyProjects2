<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students data</title>
</head>
<body style="background-image: url('background.jpg')">
	<%
	ArrayList<String> id=new ArrayList<String>();
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<String> userName=new ArrayList<String>();
	ArrayList<String> password=new ArrayList<String>();
	
	id=(ArrayList<String>)request.getSession().getAttribute("id");
	name=(ArrayList<String>)request.getSession().getAttribute("name");
	userName=(ArrayList<String>)request.getSession().getAttribute("userName");
	password=(ArrayList<String>)request.getSession().getAttribute("password");
	%>
	<h2>Students List:</h2>
	<table border="1" style="color: red; text-align: center;">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>User-name</th>
					<th>Password</th>
				</tr>
	<%
		for(int i=0; i<id.size(); i++){
		%>
				<tr>
					<td><%=id.get(i) %></td>
					<td><%=name.get(i) %></td>
					<td><%=userName.get(i) %></td>
					<td><%=password.get(i) %></td>
				</tr>
			
			
		<% }%>
		</table>
	
	
</body>
</html>