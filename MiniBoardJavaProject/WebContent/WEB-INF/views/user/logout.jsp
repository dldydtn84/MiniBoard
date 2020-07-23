<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<c:url var='root' value='/'/>    <!-- 모든 컨텍스트 경로를 포함한 설정  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 페이지</title>
</head>
<body>
	<script type="text/javascript">
		alert("로그아웃되었습니다.");
		location.href= '${root}main'
	
	</script>
</body>
</html>