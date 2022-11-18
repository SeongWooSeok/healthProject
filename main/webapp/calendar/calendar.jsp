<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
	<style>
		#attendance{
		margin: 0 auto;
		}
	</style>
<layout:main title="출석체크">

<html>
	<head>

		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
	</head>
	<body>
			<div class='calendar_tab'>
				<a href='?year=${prevYear}&month=${prevMonth}'>이전달</a>
				${year}년 ${month}월
				<a href='?year=${nextYear}&month=${nextMonth}'>다음달</a>
			</div>
			<section id="calendar">
				<ul class='yoil'>
					<c:forEach var="yoil" items="${yoils}">
						<li>${yoil}</li>
					</c:forEach>
				</ul>
				<!--// yoil -->
				<ul>
				<c:forEach var="day" items="${days}">
					<li>${day}</li>
				</c:forEach>	
				</ul>
			</section>
	<div style="text-align: center;">
	<button type="submit" style="display: inline-block; width:20%; height:5%; font-size:20px">출석체크!</button>
	</div>
	</body>
</html>
</layout:main>