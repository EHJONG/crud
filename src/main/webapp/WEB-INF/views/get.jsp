<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board글</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시판 Get Method</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>BNO</label> <input class="form-control" name="bno"
						value="<c:out value = "${board.bno }"/>" readonly="readonly">
				</div>


				<div class="form-group">
					<label>TitlE</label> <input class="form-control" name="title"
						value='<c:out value = "${board.title }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>content</label>
					<textarea rows="10" cols="100" readonly="readonly" name="content"> <c:out
							value="${board.content }"></c:out></textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input class="form-control" name="writer"
						value="<c:out value ="${board.writer }"/>" readonly="readonly">
				</div>


				<button data-oper="modify"
					onclick="location.href = '/board/modify?bno=<c:out value = "${board.bno }"/>'"
					class="btn btn-default">확인</button>
				<button onclick="location.href = '/board/list'"
					class="btn btn-default">다시</button>

			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel body -->
	</div>
	<!-- end panel -->
</div>
<!-- ./dorw -->
