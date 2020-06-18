<%@page import="com.blog.tistory.db.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DB연결 테스트
	Connection conn = DBConn.getConnection();
%>
<% if(conn != null) {%>
<h1>DB연결 성공</h1>
<% }else{ %>
<h1>DB연결 실패</h1>
<% } %>
</body>
</html>