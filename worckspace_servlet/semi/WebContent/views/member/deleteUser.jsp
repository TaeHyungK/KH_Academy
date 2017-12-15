<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!check_user}">
	<script>
		alert('예약된 항공권이 있습니다. 회원탈퇴가 불가합니다.');
		location.href='../main/main.do';
	</script>
</c:if>
<c:if test="${check}">
<script>
	alert('회원탈퇴 완료!');
	location.href='../main/main.do';
</script>
</c:if>
<c:if test="${!check}">
	<script>
		alert('비밀번호가 불일치합니다.');
		history.go(-1);
	</script>
</c:if>