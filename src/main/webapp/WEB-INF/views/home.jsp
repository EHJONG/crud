<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix = "form" uri ="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form action = "test" method = "POST">
	<input type = "text" name = "name">	
	<input type = "password" name ="pw">
	<button>submit</button>
</form>

<br>
<a href = "list">list !</a><br>

<form action = "delete" method = "get">
	<input type = "text" name = "name">
	<button>submit</button>
</form>

<form action ="update" method = "get">
	now name :<input type ="text" name ="name">
	changing name : <input type = "text" name = "changingName">
	<button>submit</button> 
</form>