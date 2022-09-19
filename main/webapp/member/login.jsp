<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="로그인">
	<form id="frmLogin" name="frmLogin" method="post" action="<c:url value="/member/login" />" target="ifrmProcess" autocomplete="off">
		<dl>
			<dt>아이디</dt>
			<dd><input type="text" name="memId" value="${cookie.saveMemId.value}"></dd>
		</dl>
		<dl>
			<dt>비밀번호</dt>
			<dd>
				<input type="password" name="memPw">
			</dd>
		</dl>
		<div>
			<input type="checkbox" name="saveMemId" id="saveMemId"${ empty cookie.saveMemId ? "" : " checked"}>
			<label for="saveMemId">아이디 저장</label>
		</div>
		
		<div class="btn-grp">
			<button type="submit">로그인</button>
		</div>
	</form>
</layout:main>