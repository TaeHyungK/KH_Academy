<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
<%
	String realFolder = ""; //파일 업로드 절대 경로
	
	//파일 업로드 경로
	String saveFolder = "/upload"; //파일 업로드 상대 경로
	String encType = "UTF-8"; //인코딩 타입
	int maxSize = 5*1024*1024; //파일의 최대 업로드 사이즈 (=5MB)
	
	//상대 경로를 통해 파일 업로드 절대 경로 구하기
	realFolder = application.getRealPath(saveFolder);
	
	out.println("파일 업로드 절대 경로 : " + realFolder + "<br>");
	out.println("--------------------------<br>");
	
	try{//																						생략가능!, 파일이름이 중복되면 어떻게 처리할지에 대한 정책을 가진 객체
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		out.println("작성자 : " + multi.getParameter("user") + "<br>");
		out.println("제목 : " + multi.getParameter("title") + "<br>");
		out.println("------------------<br>");
		
		//파일 정보 처리
		//전송 전 원래의 파일 이름
		String original = multi.getOriginalFileName("uploadFile");
		//서버에 저장된 파일 이름
		String fileName = multi.getFilesystemName("uploadFile");
		//전송된 파일의 컨텐트 타입
		String type = multi.getContentType("uploadFile");
		
		out.println("전송 전 원래의 파일 이름 : " + original + "<br>");
		out.println("서버에 저장된 파일 이름 : " + fileName + "<br>");
		out.println("전송된 파일의 컨텐트 타입 : " + type + "<br>");
		
	}catch(IOException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>