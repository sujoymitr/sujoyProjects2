<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body style="background-image: url('background.jpg')">
<%String name=(String)request.getSession().getAttribute("name"); %>
<h1 style="color: red; text-align: center;">Welcome <%=name %>!</h1>
<h2 style="color: green; text-align: center;">Please do the necessary changes if you want to.</h2>
<h3 style="text-align: center;"><b><a href="students.html">Add Students</a><span>&nbsp;&nbsp;&nbsp;</span><a href="test1.html">Add Test1 Questions</a></b></h3>
<h3 style="text-align: center;"><b><a href="ShowStudents">Show Students Info</a>&nbsp;&nbsp;&nbsp;<a href="test2.html">Add Test2 Questions</a></b></h3>
<h3 style="text-align: center;"><b><a href="ShowResult">Show Results</a></b></h3>
</body>
</html>