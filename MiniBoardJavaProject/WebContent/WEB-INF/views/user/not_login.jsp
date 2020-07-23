<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<c:set var='root' value='${pageContext.request.contextPath }/'/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인하지 안았을 경우 처리</title>
</head>
<body>
	<script type="text/javascript">
		alert("로그인 해주세요.");
		location.href= '${root}user/login'
	
	</script>
</body>
</html>