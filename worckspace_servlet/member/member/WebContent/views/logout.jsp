<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     //로그 아웃
     session.invalidate();
     response.sendRedirect("main.jsp");
     

%>