<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
 <div class="row">
  <!-- left column -->
  <div class="col-md-12">
   <!-- general form elements -->
   <div class='box'>
    <div class="box-header with-border">
     <h3 class="box-title">Board List</h3>
    </div>
    <div class='box-body'>
     <button id='newBtn'>New Board</button>
    </div>
   </div>
   <div class="box">
    <div class="box-header with-border">
     <h3 class="box-title">LIST PAGING</h3>
    </div>
    <div class="box-body">
     <table class="table table-bordered">
      <tr>
       <th style="width: 10px">BNO</th>
       <th>TITLE</th>
       <th>WRITER</th>
       <th>REGDATE</th>
       <th style="width: 40px">VIEWCNT</th>
      </tr>

      <c:forEach items="${list}" var="boardVO">

       <tr>
        <td>${boardVO.bno}</td>
        <td><a
         href='/board/readPage?bno=${boardVO.bno}'>
          ${boardVO.title}</a></td>
        <td>${boardVO.writer}</td>
        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
          value="${boardVO.regdate}" /></td>
        <td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
       </tr>

      </c:forEach>

     </table>
    </div>
    <!-- /.box-body -->


    <div class="box-footer">

<!-- p.276의 내용을 입력하세요. -->

	<div class="text-center">
		<ul class="pagination">
		
		<!-- 스프링 MVC를 이용하는 방식 -->
			<c:if test="${pageMaker.prev}">
				<li><a href="listPage?page=${pageMaker.startPage -1}">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage}" var = "idx">
				<li 
					<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
					<a href="listPage?page=${idx}">${idx}</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage>0 }">
				<li><a href="listPage?page=${pageMaker.endPage +1}">&raquo;</a>
			</c:if> 
			
			
			<!-- JAVASCRIPT를 이용하는 링크의 처리 
			
			     <li>
			     	<a href="1">1</a>
			     </li>
				 <li><a href="2">2</a></li>
				 <li><a href="3">3</a></li>
				 <li><a href="4">4</a></li>
				 <li><a href="5">5</a></li>
				 <li><a href="6">6</a></li>
				-->
			
		</ul>
	</div>


    </div>
    <!-- /.box-footer-->
   </div>
  </div>
  <!--/.col (left) -->

 </div>
 <!-- /.row -->
</section>
<!-- /.content -->

				<form id="jobForm">
			   	<input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
			   	<input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum}>
				</form>


<script>
	 var result = '${msg}';
	
	 if (result == 'success') {
	  alert("처리가 완료되었습니다.");
	 }
	 
	 $(".pagination li a").on("click", function(event){
	  
	 // event.preventDefault(); //JS로페이징할때
	  
	  var targetPage = $(this).attr("href");
	  
	  var jobForm = $("#jobForm");
	  jobForm.find("[name='page']").val(targetPage);
	  jobForm.attr("action","/board/listPage").attr("method", "get");
	  jobForm.submit();
	 });
	 
</script>

<%@include file="../include/footer.jsp"%>