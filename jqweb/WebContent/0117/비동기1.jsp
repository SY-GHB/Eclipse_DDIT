<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP: Java Server Page</h1>

<%
 //인코딩방식 지정
 request.setCharacterEncoding("UTF-8");
 
 String userName = request.getParameter("name");
 String userID = request.getParameter("id");
 
//  out.print("<table border='1'><tr><td>아이디</td><td>"+userID+"</td></tr><tr><td>이름</td><td>"+userName+"</td></tr></table>");

%>

<table border="1">

 <tr>
  <td>아이디</td>
  <td><%=userID %></td>
 </tr>
 <tr>
  <td>이름</td>
  <td><%=userName %></td>
 </tr>
 
</table>

</body>
</html>