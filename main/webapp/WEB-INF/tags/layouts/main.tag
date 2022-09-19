<%@ tag description="메인 공통 레이아웃" pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" type="java.lang.String" %>
<fmt:setBundle basename="bundle.common" />
<layout:common title="${title}">
	<jsp:attribute name="header">
	<header>
		<section class='top-menu'>
			<div class='layout_width'>
				<c:if test="${empty member}">
					<a href="<c:url value="/member/join" />">
						<fmt:message key="JOIN" />
					</a>
					<a href="<c:url value="/member/login" />">
						<fmt:message key="LOGIN" />
					</a>
				</c:if>
				<c:if test="${!empty member}">
					${member.memNm}(${member.memId})님 로그인...
					<a href="<c:url value="/mypage" />">
						<fmt:message key="MYPAGE" />
					</a>
					<a href="<c:url value="/member/logout" />">
						<fmt:message key="LOGOUT" />
					</a>
					<c:if test="${member.memType == 'admin'}">
						<a href="<c:url value="/admin" />">
							<fmt:message key="ADMIN_MENU" />
						</a>
					</c:if>
				</c:if>
			</div>
		</section>
		<section class='logo'>로고!</section>
	</header>
	</jsp:attribute>
	<jsp:attribute name="menu">
	<nav>
		<div class='layout_width'>
			<a href="#">메뉴1</a>
			<a href="#">메뉴2</a>
			<a href="#">메뉴3</a>
		</div>
	</nav>
	</jsp:attribute>
	<jsp:attribute name="footer">
	<footer>
		&copy; Copyright...	
	</footer>
	</jsp:attribute>
	<jsp:body>
	<main class='layout_width'>
		<jsp:doBody />
	</main>	
	</jsp:body>
</layout:common>