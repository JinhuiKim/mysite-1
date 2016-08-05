<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 
 request.setCharacterEncoding("utf-8");
 String result = request.getParameter("r");
 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


		<div id="header">
			<h1>MySite</h1>
			<ul>
			<%if("loginsuccess".equals(result)){ %>
				<li><a href="">회원정보수정</a><li>
				<li><a href="/mysite/main/index.jsp">로그아웃</a><li>
				<li>님 안녕하세요 ^^;</li>
				
				<%}else{ %>
				
				<li><a href="/mysite/user?a=loginform">로그인</a><li>
				<li><a href="/mysite/user?a=joinform">회원가입</a><li>
				
				
				
				<%} %>
			</ul>
		</div>

		


</body>
</html>