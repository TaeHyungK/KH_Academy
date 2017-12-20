onmessage = function(event){
	//백그라운드로 처리될 코드 작성
	var result = '';
	var dan  = event.data; //인자로 넘어온 데이터 호출
	
	for(var i=1;i<10;i++){
		result += dan + '*' + i + '=' + dan*i + '<br>'; 
	}
	
	//ui쪽에 데이터 전달
	postMessage(result);
	
};