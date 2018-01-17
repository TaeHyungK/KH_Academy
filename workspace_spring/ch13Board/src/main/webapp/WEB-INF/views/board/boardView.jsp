<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="page-main-style">
	<h2>${board.title}</h2>
	<ul>
		<li>번호 : ${board.num}</li>
		<li>작성자 : ${board.id}</li>
		<li>조회수 : ${board.hit}</li>
		<li>등록일 : ${board.reg_date}</li>
		<c:if test="${!empty board.filename}">
		<li>첨부파일 : <a href="file.do?num=${board.num}">${board.filename}</a></li>
		</c:if>
	</ul>
	<p>
		${board.content}
	</p>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(board.filename,'.jpg')|| fn:endsWith(board.filename,'.JPG')||
				  fn:endsWith(board.filename,'.gif')|| fn:endsWith(board.filename,'.GIF')||
				  fn:endsWith(board.filename,'.png')|| fn:endsWith(board.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?num=${board.num}" style="max-width:500px">
	</div>
	</c:if>
	<div class="align-right">
		<c:if test="${!empty user_id && user_id == board.id }">
		<input type="button" value="수정" onclick="location.href='update.do?num=${board.num}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?num=${board.num}'">
		</c:if>
		<input type="button" value="목록" onclick="location.href='list.do'"> 
	</div>
</div>