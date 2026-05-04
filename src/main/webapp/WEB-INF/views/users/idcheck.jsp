<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .red {color: red;}
 .green {color: green;}
</style>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="/Users/DupCheck" method="get">
	<input type="text" name="userid" value="${param.userid}" />
	<input type="submit" value="중복확인" /><br />
	<div id="msg">${ msg }</div>
	<input type="button" value="사용하기" id="btnClose"/>
	
	</form>
	<script>
	
	// 새창(페이지)이 열릴 때
	document.addEventListener("DOMContentLoaded", function(){
		const thisUserid   = window.document.querySelector('[name=userid]')
		const parentUserid = window.opener.document.querySelector('[name="userid"]')
		thisUseridEl.value = parentUserid.value;
		
	})
	
    // 사용하기 버튼을 클릭
    const  btnCloseEl = document.querySelector('#btnClose') 
    btnCloseEl.addEventListener('click', function() {
    	//alert('ok')
    	const  thisUseridEl    = window.document.querySelector('[name=userid]');
    	const  parentUseridEl  = window.opener.document.querySelector('[name="userid"]');
  		parentUseridEl.value   = thisUseridEl.value;
  		window.close();
    })
	
	</script>
</body>
</html>