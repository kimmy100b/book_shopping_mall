<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<style>
#popup {
	z-index: 3;
	position: fixed;
	text-align: center;
	left: 20%;
	top: 10%;
	background-color: white;
	border: 3px solid #87cb42;
}

#close {
	z-index: 4;
	float: right;
}
</style>
<script type="text/javascript">
	function imagePopup(type) {
		if (type == 'open') {
			// 팝업창을 열기
			jQuery('#layer').attr('style', 'visibility:visible');
			jQuery('#layer').height(jQuery(document).height());
		}

		else if (type == 'close') {
			// 팝업창을 닫기
			jQuery('#layer').attr('style', 'visibility:hidden');
		}
	}
	
	function fn_hidePopup() {
		session.setAttribute("isPopUp", n);
	}
</script>
<div id="layer" style="visibility: visible">
	<div id="popup">
		<!-- 팝업창 닫기 버튼 -->
		<a href="javascript:"
			onClick="javascript:imagePopup('close', '.layer01');"> <img
			src="${contextPath}/resources/image/close.png" id="close" />
		</a> <img width="695" src="${contextPath}/resources/image/test.jpg" />
		<h5>신상품이 출시 되었습니다.</h5>
		<h5>
			오늘 그만 보기 <input type="checkbox" onClick="fn_hidePopup()" />
		</h5>
	</div>
</div>

