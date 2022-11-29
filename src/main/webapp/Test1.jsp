<%@ page import= "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test1</title>
</head>
<body style="background-image: url('background.jpg')">
	<h3 style="color: red; text-align: center;">All the best!</h3>
	<%
	ArrayList<String> question=new ArrayList<String>();
	question=(ArrayList<String>)request.getSession().getAttribute("question");
	ArrayList<String> option1=new ArrayList<String>();
	option1=(ArrayList<String>)request.getSession().getAttribute("option1");
	ArrayList<String> option2=new ArrayList<String>();
	option2=(ArrayList<String>)request.getSession().getAttribute("option2");
	ArrayList<String> option3=new ArrayList<String>();
	option3=(ArrayList<String>)request.getSession().getAttribute("option3");
	ArrayList<String> option4=new ArrayList<String>();
	option4=(ArrayList<String>)request.getSession().getAttribute("option4");
	ArrayList<String> currectAns=new ArrayList<String>();
	currectAns=(ArrayList<String>)request.getSession().getAttribute("currectAns");
	%>
	<form action="Test1result" method="post" style="color: green; text-align: center;">
		<label>Enter your username:</label>
		<input type="text" name="name"><br>
		
		<%for(int i=0; i<question.size();i++){
			
		%>
		<label><%=question.get(i) %></label><br>
		<input type="radio" name="answer<%=i %>" value="<%=option1.get(i) %>">
		<%=option1.get(i)%><br>
		
		<input type="radio" name="answer<%=i %>" value="<%=option2.get(i) %>">
		<%=option2.get(i)%><br>
		
		<input type="radio" name="answer<%=i %>" value="<%=option3.get(i) %>">
		<%=option3.get(i)%><br>
		
		<input type="radio" name="answer<%=i %>" value="<%=option4.get(i) %>">
		<%=option4.get(i)%><br>
		
		<%}  %>
		<input type="submit" value="Submit">
		
	</form>
</body>
</html>