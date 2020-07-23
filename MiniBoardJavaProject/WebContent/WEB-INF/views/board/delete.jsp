<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<c:set var='root' value='${pageContext.request.contextPath }/'/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 기능 구현</title>
</head>
<body>
	<script type="text/javascript">
		alert('삭제 되었습니다.');
		location.href='${root}board/main'
	</script>

</body>
</html>