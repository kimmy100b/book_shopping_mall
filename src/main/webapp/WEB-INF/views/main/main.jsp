<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	function fn_hidePopup() {
		popup = document.getElementById("popup");
		popup.style.visibility = "hidden";
	}
</script>
<div id="ad_main_banner">
	<ul class="bjqs">
		<li><img width="775" height="145"
			src="${contextPath}/resources/image/main_banner01.jpg"></li>
		<li><img width="775" height="145"
			src="${contextPath}/resources/image/main_banner02.jpg"></li>
		<li><img width="775" height="145"
			src="${contextPath}/resources/image/main_banner03.jpg"></li>
	</ul>
</div>
<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>베스트셀러</h3>
	<c:forEach var="item" items="${goodsMap.bestseller }">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<img class="link" src="${contextPath}/resources/image/1px.gif">
			</a> <img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="price">
				<fmt:formatNumber value="${item.goods_price}" type="number"
					var="goods_price" />
				${goods_price}원
			</div>
		</div>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>
<div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117"
		src="${contextPath}/resources/image/sub_banner01.jpg">
</div>
<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>새로 출판된 책</h3>
	<c:forEach var="item" items="${goodsMap.newbook }">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<img class="link" src="${contextPath}/resources/image/1px.gif">
			</a> <img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
			<div class="title">${item.goods_title }</div>
			<div class="price">
				<fmt:formatNumber value="${item.goods_price}" type="number"
					var="goods_price" />
				${goods_price}원
			</div>
		</div>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>

<div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117"
		src="${contextPath}/resources/image/sub_banner02.jpg">
</div>


<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>스테디셀러</h3>
	<c:forEach var="item" items="${goodsMap.steadyseller }">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<img class="link" src="${contextPath}/resources/image/1px.gif">
			</a> <img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
			<div class="title">${item.goods_title }</div>
			<div class="price">
				<fmt:formatNumber value="${item.goods_price}" type="number"
					var="goods_price" />
				${goods_price}원
			</div>
		</div>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>

	<div id="popup">
		<!-- 팝업창 닫기 버튼 -->
		<a href="javascript:"
			onClick="javascript:fn_hidePopup();"> 
			<img src="${contextPath}/resources/image/close.png" id="close" />
		</a> 
		<h5>신상품이 출시 되었습니다!</h5>
		<img width="695" src="${contextPath}/resources/image/test.jpg" />
		<!-- <h5>
			오늘 그만 보기 <input type="checkbox" onClick="fn_hidePopup()" />
		</h5> -->
	</div>


