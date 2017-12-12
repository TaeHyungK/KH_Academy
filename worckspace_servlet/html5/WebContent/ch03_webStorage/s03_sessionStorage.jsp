<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Storage</title>
<script type="text/javascript">
/*
세션 스토리지는 브라우저가 열려있는 동안 모든 데이터를 기억하고 있다가
탭(또는 창)을 닫으면 지워지는 저장 공간
*/
	window.onload=function(){
		//저장된 데이터 읽기
		load();
		
		var save = document.getElementById('save');
		save.onclick=function(){
			var first = document.getElementById('first');
			var name = first.value;
			
			//세션스토리지에 데이터 저장
			//sessionStorage.setItem('name', name);
			sessionStorage.name = name;
			
			load();
		}
	};
	
	function load(){
		var display = document.getElementById('display');
		//var name = sessionStorage.getItem('name');
		var name= sessionStorage.name;
		
		if(name){
			display.innerHTML = '저장된 값 : ' + name;
		}
	}
</script>
</head>
<body>
	<h2>세션 스토리지</h2>
	<input type="text" name="first" id="first">
	<button id="save">저장</button>
	<div id="display">비어있음</div>
</body>
</html>