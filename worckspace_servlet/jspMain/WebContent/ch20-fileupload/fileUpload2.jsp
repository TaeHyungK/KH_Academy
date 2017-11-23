<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.io.IOException" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중 파일 업로드</title>
</head>
<body>
<%
   String realFolder = "";//파일 업로드 절대 경로
   
   //파일 업로드 경로
   String saveFolder = "/upload";
   String encType = "utf-8";//인코딩 타입
   int maxSize = 5*1024*1024;//파일의 최대업로드 사이즈,5M
   
   //파일업로드 절대 경로
   realFolder = application.getRealPath(saveFolder);
   
   try{//                                       upload 절대경로 ,파일 최대업로드 사이즈 인코딩   
      MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
      out.println("작성자 : " + multi.getParameter("user") + "<br>");
      out.println("제목 : " + multi.getParameter("title") + "<br>");
      out.println("[업로드된 파일]<br>");
      out.println("첫번째 파일 : " + multi.getFilesystemName("uploadFile") + "<br>");
      out.println("두번째 파일 : " + multi.getFilesystemName("uploadFile2"));
      
   }catch(IOException e){
      e.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }
   
%>
</body>
</html>


















