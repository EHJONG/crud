<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "root" value = "${pageContext.request.contextPath }/"></c:set>
    
<script>
	alert("삭제 하였습니다")
	locaion.href = "${root}home/list"
</script>