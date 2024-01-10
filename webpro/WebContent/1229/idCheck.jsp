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

<style>
p{
  margin: 20px;
  font-size: 1.5rem;
}
span {
	color: red;
	font-weight: bold;
}

#gr{
  color: lightgreen;
}

</style>

</head>
<body>

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
//시작 전에 ojdbc6.jar를 WEB-INF의 lib에 넣어뒀었다!!!
  //입력한 id값을 가져온다.
  String userId = request.getParameter("id");

  // OracleDriver 클래스를 로드시킨다.
  Class.forName(driver);

  //db연결객체
  conn= DriverManager.getConnection(url, user, password);

  //sql쿼리문 작성
  String sql = "select * from member where mem_id = ?";

  //실행 객체
  ps = conn.prepareStatement(sql);
  
  //실행문에 값 셋팅
  ps.setString(1, userId);
  
  //실행  select는 쿼리로 실행, insert, update, delete는 executeUpdate()로 실행
  // 실행한 결과가  rs(resultset)
  rs = ps.executeQuery();
  
  //실행결과 비교하기 - 사용가능 불가능 상태를 출력
  if(rs.next()){ %>
	  <p><%=userId%>는 <span>사용불가능</span> 아이디입니다.</p>
<% }else{%>
	  <p><%=userId%>는 <span id="gr">사용가능</span> 아이디입니다.</p>
<%	  
  
   }

%>

</body>
</html>