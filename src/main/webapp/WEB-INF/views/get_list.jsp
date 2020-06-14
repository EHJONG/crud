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
			<div class="panel-heading">게시판</div>
			<!-- /.panel-heading -->
			<div class="panel-heading">
				Board List PAGE
				<button id="regBtn" type="button" class="btn btn-xs pull-right">등록</button>
			</div>
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list }" var="board">
						<tr>
							<td><c:out value="${board.bno }"></c:out>
							<td><a
								href="/board/get?bno=<c:out value = "${board.bno }"/>"> <c:out
										value="${board.title }"></c:out>
							</a></td>


							<td><c:out value="${board.writer }"></c:out>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
									value="${board.regdate }"></fmt:formatDate></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
									value="${board.updateDate }"></fmt:formatDate></td>
						</tr>
					</c:forEach>
				</table>

		
				<c:forEach var = "counter" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
						
						<a href = "get_list?currentPage=${counter }">${counter }</a>
						
				</c:forEach>




				<script>
					//이전 버튼 이벤트
					function fn_prev(page, range, rangeSize) {
						var page = ((range - 2) * rangeSize) + 1;
						var range = range - 1;
						var url = "${pageContext.request.contextPath}/board/getBoardList";
						url = url + "?page=" + page;
						url = url + "&range=" + range;
						location.href = url;
					}

					//페이지 번호 클릭
					function fn_pagination(page, range, rangeSize, searchType,
							keyword) {
						var url = "${pageContext.request.contextPath}/board/getBoardList";
						url = url + "?page=" + page;
						url = url + "&range=" + range;
						location.href = url;
					}

					//다음 버튼 이벤트
					function fn_next(page, range, rangeSize) {

						var page = parseInt((range * rangeSize)) + 1;

						var range = parseInt(range) + 1;

						var url = "${pageContext.request.contextPath}/board/getBoardList";

						url = url + "?page=" + page;

						url = url + "&range=" + range;

						location.href = url;

					}
				</script>

				

				<div>
					<button type="button" class="btn btn-sm btn-primary"
						id="btnWriteForm">글쓰기</button>
				</div>


				<!-- pagination{s} -->

				<div id="paginationBox">

					<ul class="pagination">

						<c:if test="${pagination.prev}">

							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>

						</c:if>



						<c:forEach begin="${pagination.startPage}"
							end="${pagination.endPage}" var="idx">

							<li
								class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
								class="page-link" href="#"
								onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
									${idx} </a></li>

						</c:forEach>



						<c:if test="${pagination.next}">

							<li class="page-item"><a class="page-link" href="#"
								onClick="fn_next('${pagination.range}', 

'${pagination.range}', '${pagination.rangeSize}')">Next</a></li>

						</c:if>

					</ul>

				</div>

				<!-- pagination{e} -->



			</div>

			






			<!-- Modal start -->
			<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLable">Modal title</h4>
							</div>
							<div class="modal-body">완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소!</button>
								<button type="button" class="btn btn-primary">Save
									Changes!</button>
							</div>
						</div>
						/.modal content
					</div>
					/.modal-dialog
				</div> -->

			<!-- Modal end -->

		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
</div>
<!-- /.row -->

<!-- <script type="text/javascript">
	$(document).ready(
			function() {
				var result = '<c:out value = "${result}"/>';

				checkModal(result);

				history.replaceState({},null, null);
				
				function checkModal(result) {
					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal-body").html(
								"게시글 " + parseInt(result) + "번이 등록 되었습니다.");
					}
					$("#myModal").modal("show");
				}
				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
			});
</script>
 -->