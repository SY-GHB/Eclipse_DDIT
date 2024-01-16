<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//한글이 안 깨지게 인코딩방법 지정
  request.setCharacterEncoding("utf-8");
	//hideen인 id는 가져올 수 있지만
  String userId = request.getParameter("id");
  String userPass = request.getParameter("pass");
  //disabled인 name은 못가져올듯..
  String userName = request.getParameter("name");
  
  out.println("id: "+userId);
  out.println("pass: "+userPass);
  //진짜못가져와서 null됨
  out.println("이름: "+userName);
%>
</body>
</html>