<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
 color: red;
}
table{
 border: 1px solid blue;
 text-align: center;
 margin: 50px;
}
td{
 width: 100px;
 height: 50px;
 padding: 10px;
}
.tline{
 width: 200px;
}
</style>

</head>
<body>
<h1>JSP: Java Sever Page</h1>

<%
 request.setCharacterEncoding("UTF-8");

 String userName = request.getParameter("name");
 String title = request.getParameter("title");
 String area = request.getParameter("area");
 
 String cars1 = request.getParameter("cars1");
 String[] cars2 = request.getParameterValues("cars2");
 // 엔터 기호(\r(carrage return, 커서를 앞으로 땡김)\n(줄바꿈))이 포함, 브라우저상에서는 /r기능은 의미가 없다
 // \n을 <br>로 바꾸면 줄바꿈을 입력받아 출력할 수 있다.
 
 
 String str = "";
 for(String car : cars2){
	 str += car+ "<br>";
 }
 area = area.replaceAll("\n", "<br>");
 //기본 replaceAll(String regex, String rempalcement)에서 regex의 의미: 정규식, 데이터의 입력형식
 
 // db처리 - CRUD
 // 결과값으로 응답페이지를 생성 - 우리는 DB처리를 안해서 별도의 응답페이지가업당
%>

<table border="1">
 
 <tr>
 <td>이름</td>
 <td class = "tline"><%= userName %></td>
 </tr>
 
 <tr>
 <td>제목</td>
 <td class = "tline"><%= title %></td>
 </tr>
 
 <tr>
 <td>내용</td>
 <td class = "tline"><%= area %></td>
 </tr>

 <tr>
 <td>자동차1</td>
 <td class = "tline"><%= cars1 %></td>
 </tr>

 <tr>
 <td>자동차2</td>
 <td class = "tline"><%= str %></td>
 </tr>

</table>


</body>
</html>