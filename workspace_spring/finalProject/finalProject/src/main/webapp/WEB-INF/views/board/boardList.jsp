<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<div class="page-main-style">
	<h2>게시판 목록</h2>
	<form action="list.do" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield">
					<option value="title">제목</option>
					<option value="id">아이디</option>
					<option value="content">내용</option>
				</select>
			</li>
			<li>
				<input type="text" name="keyword" id="keyword">
			</li>
			<li>
				<input type="submit" value="검색">
			</li>
		</ul>
	</form>
	<div class="align-right">
		<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
		<c:if test="${empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'" disabled>
		</c:if>
	</div>
	<c:if test="${count==0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
		<table>
			<tr>
				<th>번호</th>
				<th width="400">제목</th>
				<th>ID</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="article" items="${list}">
			<tr>
				<td>${article.num}</td>
				<td><a href="detail.do?num=${article.num}">${article.title}(${article.reply_cnt})</a></td>
				<td>${article.id}</td>
				<td>${article.regdate}</td>
				<td>${article.hit}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>