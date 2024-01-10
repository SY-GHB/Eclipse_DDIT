<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 border: 20px solid skyblue;
 border-spacing: 20px;
}

td{
  width: 50px;
  height: 50px;
  text-align: center;
  border-right: none; 
  border-left: none;
  border-top: none; 
}

</style>
</head>
<body>
<h1>nth GUGU</h1>
<%
 String dan = request.getParameter("dan");
 String str = "<table border ='1'>";
 
 for(int i=1; i<=9; i++){
	 str += "<tr><td>"+dan+"</td><td>*</td>"+"<td>"+i+"</td>"+"<td>=</td>" + "<td>"+
			 (i*(Integer.parseInt(dan)))+"</td></tr>";
 }
 
str += "</table>";
%>

<%=
str
%>

</body>
</html>