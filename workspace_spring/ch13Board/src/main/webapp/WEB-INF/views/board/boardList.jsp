<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="page-main-style">
	<h2>게시판 목록</h2>
	<div class="align-right">
		<c:if test="${!empty user_id}">
		<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count == 0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>번호</th>
			<th width="400">제목</th>
			<th>ID</th>
			<th>등록날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="article" items="${list}">
			<tr>
				<td>${article.num}</td>
				<td><a href="detail.do?num=${article.num}">${article.title}</a></td>
				<td>${article.id}</td>
				<td>${article.reg_date}</td>
				<td>${article.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>

110-479-225996