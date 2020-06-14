<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>

<c:forEach var="listOut" items="${list}">		
		<li>이름 : ${listOut.name }
		시간 : ${listOut.time }<br>
		</li>
</c:forEach>