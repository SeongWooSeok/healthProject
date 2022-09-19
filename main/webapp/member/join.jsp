<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="회원가입">
<form id="frmRegist" name="frmRegist" method="post" action="<c:url value="/member/join" />" target="ifrmProcess" autocomplete="off">

<jsp:include page="_form.jsp" />

<div class='term_agree'>
	<input type="checkbox" name="isAgree" id="isAgree">
	<label for="isAgree">약관에 동의</label>
</div>

<div class='btn-grp'>
	<button type="reset">다시입력</button>
	<button type="submit">가입하기</button>
</div>
</form>
</layout:main>
