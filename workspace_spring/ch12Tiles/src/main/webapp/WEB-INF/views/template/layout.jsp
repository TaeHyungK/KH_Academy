<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"> </tiles:getAsString></title>
</head>
<body>
<table style="width:1000px;">
	<tr height="100" valign="middle">
		<td colspan="2"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr height="670">
		<td width="15%" valign="top"><tiles:insertAttribute name="menu"/></td>
		<td width="85%" valign="top"><tiles:insertAttribute name="body"/></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insertAttribute name="footer"/></td>
	</tr>
</table>
</body>
</html>