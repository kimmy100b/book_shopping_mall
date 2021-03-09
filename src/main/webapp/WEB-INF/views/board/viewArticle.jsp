<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="article" value="${articleMap.article}" />
<c:set var="imageFileList" value="${articleMap.imageFileList}" />

<%
	request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>글보기</title>
<style>
#tr_btn_modify, .btn_file_delete, #tr_add_file {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
     function backToList(obj){
	    obj.action="${contextPath}/board/listArticles.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		 var imgFileName = document.getElementsByClassName("i_imageFileName");
		 var btnFileDelete = document.getElementsByClassName("btn_file_delete");
		 for ( var i=0 ; i<imgFileName.length ; i++ ){
			 btnFileDelete[i].style.display="block"; 
		 }
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_add_file").style.display="block";
		 $('#btn_modify').hide();
		 $('#btn_delete').hide();
	 }
	 
	 function fn_delete_file(idx, fileNO, fileName){
		 var trFileList = ".tr_file_list" + idx;
		 var trBtnFile = ".tr_btn_file" + idx;
	 	 $(trFileList).hide();
	 	 $(trBtnFile).hide();
	 	 
	 	 // fileNO 저장
	 	 if($('#del_files_no').val()===''){
	 		$('#del_files_no').val(fileNO);
	 	 } else {
	 		$('#del_files_no').val($('#del_files_no').val()+','+fileNO);
	 	 }	
	 	 
	 	// fileName 저장 
	 	if($('#del_files_name').val()===''){
	 		$('#del_files_name').val(fileName);
	 	 } else {
	 		$('#del_files_name').val($('#del_files_name').val()+','+fileName);
	 	 }
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do?articleNO=${article.articleNO}";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 }
	 
	 function fn_reply_form(isLogOn, url, parentNO){
		 if (isLogOn != '' && isLogOn != 'false') {
			 var form = document.createElement("form");
			 form.setAttribute("method", "get");
			 form.setAttribute("action", url);
			 
		     var parentNOInput = document.createElement("input");
		     parentNOInput.setAttribute("type","hidden");
		     parentNOInput.setAttribute("name","parentNO");
		     parentNOInput.setAttribute("value", parentNO);
			 
		     form.appendChild(parentNOInput);
		     document.body.appendChild(form);
			 form.submit();
		 } else {
			alert("로그인 후 글쓰기가 가능합니다.")
			location.href = loginForm + '?action=/board/articleForm.do';
		 } 		 
	 }
	 
	 function readURL(input, num) {
		var preview = '#preview'+num;
		console.log('preview:'+preview);
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $(preview).attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }
	 
	 var cnt = 1;
		function fn_addFile() {
			$("#d_file")
					.append("<br>" + "<input type='file' name='file"+cnt+"' />");
			cnt++;
		}
 </script>
</head>
<body>
	<form name="frmArticle" method="post" action="${contextPath}"
		enctype="multipart/form-data"
	>
		<input type="hidden" value="${article.parentNO }" name="parentNO" />
		<input type="hidden" name="delFilesName" id="del_files_name" />
		<input type="hidden" name="delFilesNO" id="del_files_no" />
		<table border=0 align="center">
			<tr>
				<td width="150" align="center" bgcolor=#FF9933>글번호</td>
				<td>
					<input type="text" value="${article.articleNO }" disabled
						style="width: 100%"
					/>
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">작성자 아이디</td>
				<td>
					<input type=text value="${article.id }" name="writer" disabled
						style="width: 100%"
					/>
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">제목</td>
				<td>
					<c:choose>
						<c:when test="${article.parentNO } ne '0'">
							<input type=text value="[답글]${article.title }" name="title"
								id="i_title" disabled style="width: 100%"
							/>
						</c:when>
						<c:otherwise>
							<input type=text value="${article.title }" name="title"
								id="i_title" disabled style="width: 100%"
							/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">내용</td>
				<td>
					<textarea rows="20" cols="60" name="content" id="i_content"
						disabled style="width: 100%"
					/>${article.content }</textarea>
				</td>
			</tr>

			<c:if test="${not empty imageFileList && null ne imageFileList }">
				<c:forEach var="item" items="${imageFileList}" varStatus="status">
					<tr class="tr_file_list${status.count }">
						<td width="150" align="center" bgcolor="#FF9933" rowspan="2">
							이미지${status.count }</td>
						<td>
							<input type="hidden" name="originalFileName"
								value="${item.imageFileName }"
							/>
							<img
								src="${contextPath}/downloadFile.do?articleNO=${article.articleNO}&imageFileName=${item.imageFileName}"
								id="preview${status.count }"
							/><br>
						</td>
					</tr>
					<tr class="tr_btn_file${status.count }">
						<td>
							<input type="file" name="imageFileName " class="i_imageFileName"
								disabled onchange="readURL(this, ${status.count });"
							/>
							<input type="button" value="삭제" class="btn_file_delete"
								onClick="fn_delete_file(${status.count}, ${item.imageFileNO}, '${item.imageFileName}')"
							/>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr id="tr_add_file">
				<td align="right">이미지파일 첨부</td>
				<td align="left">
					<input type="button" value="파일 추가" onClick="fn_addFile()" />
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div id="d_file"></div>
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">등록일자</td>
				<td>
					<input type=text
						value="<fmt:formatDate value="${article.writeDate}" />" disabled
					/>
				</td>
			</tr>
			<tr id="tr_btn_modify">
				<td colspan="2" align="center">
					<input type=button value="수정반영하기"
						onClick="fn_modify_article(frmArticle)"
					/>
					<input type=button value="취소" onClick="backToList(frmArticle)" />
				</td>
			</tr>

			<tr id="tr_btn">
				<td colspan="2" align="center">
					<c:if test="${memberInfo.member_id == article.id }">
						<input type="button" id="btn_modify" value="수정하기"
							onClick="fn_enable(this.form)"
						>
						<input type="button" id="btn_delete" value="삭제하기"
							onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})"
						>
					</c:if>
					<input type=button value="리스트로 돌아가기"
						onClick="backToList(this.form)"
					>
					<input type=button value="답글쓰기"
						onClick="fn_reply_form('${isLogOn}','${contextPath}/board/replyForm.do', ${article.articleNO})"
					>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>