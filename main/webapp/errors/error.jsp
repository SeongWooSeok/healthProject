<%@ page contentType="text/html; charset=utf-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<c:set var="status" value="<%=response.getStatus()%>"/>
<c:set var="method" value="<%=request.getMethod()%>"/>
<c:set var="exception" value="<%=exception%>"/>
<% if(exception != null) exception.printStackTrace(); %>

<layout:error title="${empty status ? 500 : stauts }">
	<h1>${status}</h1>
	<h2>${method} / ${requestURL}</h2>
	<h3>
	<c:if test="${! empty exception}">
	${exception.message}
	</c:if>
	<c:if test="${empty exception}">
		<c:choose>
			<c:when test="${status == 404 }">
				없는 페이지 입니다.
			</c:when>
			<c:when test="${status == 500 }">
				서버 오류입니다.
			</c:when>
			<c:otherwise>
				에러가 발생 했습니다.
			</c:otherwise>
		</c:choose>
	</c:if>
	</h3>
	
</layout:error>
