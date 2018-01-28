<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-main-style">
	<h1>글쓰기</h1>
	<!-- 	// 같은 경로에서 파일을 호출시에는 파일명만 호출해도 앞에 있는 주소는 그대로 나옴 -->
	<form:form commandName="command" action="write.do" id="write_form" enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>
		<form:hidden path="id"/>
		<ul>
			<li>
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color"/>
			</li>
			<li>
				<label for="content">내용</label>
				<form:textarea path="content"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일 업로드</label>
				<input type="file" name="upload" id="upload"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
























