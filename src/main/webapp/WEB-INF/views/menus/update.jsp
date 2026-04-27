<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/img/favicon1.png" type="image/x-icon" />
<link href="/css/common.css" rel="stylesheet" />
<style>
	table {width : 100px;}
	td {
		padding: 5px 10px;
		text-align: center;
	&:nth-of-type(1) {
		background-color: black;
		color: white;
		border: 1px solid white;
	}
	}
	
	tr:last-child>td {
		backround-color: white;
		border: 1px solid white;
	}
	
	input[type-text], input[type-number]){
		width: 100%;
	}
	input[type-submit], input[type-button]{
		width: 100px;
	}
</style>

</head>
<body>
	<main>
		<h2>메뉴 수정</h2>
		<form action="/Menus/Update" method="get">
		<table>
		<tr>
			<td>메뉴 아이디</td>
			<td><input type="text" name="menu_id" value="${menu.menu_id}" readonly /></td>
		</tr>
		<tr>
			<td>메뉴 이름</td>
			<td><input type="text" name="menu_name" value="${menu.menu_name}" /></td>
		</tr>
		<tr>
			<td>메뉴 순서</td>
			<td><input type="number" name="menu_seq" value="${menu.menu_seq}" /></td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="submit" value="수정" />
		<input type="submit" value="목록" 
			onclick="window.location.href='/Menus/List'" />
		</td>
		</tr>
		</table>
		</form>
	</main>
</body>
</html>