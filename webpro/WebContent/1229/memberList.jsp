<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Diphylleia&display=swap" rel="stylesheet">

<style>
h1{
 font-family: 'Diphylleia', serif;
 margin-left: 150px;
}
table{
 margin-left: 20px;
 text-align: center;
}
td{
 width: 150px;
 height: 40px;
 border: 1px inset lightblue;
}

</style>
</head>
<body>
<h1>MEMBERLIST</h1>
<%!
private Connection conn = null;
private ResultSet rs = null;
private PreparedStatement ps = null;
private String driver = "oracle.jdbc.driver.OracleDriver";
private String url ="jdbc:oracle:thin:@localhost:1521:xe";
private String user ="SY97";
private String password ="java";
%>


<%
Class.forName(driver);
conn = DriverManager.getConnection(url, user, password);
String sql = "select mem_id, mem_name, mem_hp from member";

ps = conn.prepareStatement(sql);

rs = ps.executeQuery();

%>

<table border = '1'>
<tr><td>아이디</td><td>이름</td><td>전화번호</td></tr>

<%
while(rs.next()){
	String id= rs.getString(1);
	String name= rs.getString("mem_name");
	String hp= rs.getString("mem_hp");
%>
 <tr><td><%=id %></td><td><%=name %></td><td><%=hp %></td></tr>
	
<%	
}
%>

</table>
</body>
</html>