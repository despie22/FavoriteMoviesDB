<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!</title>
<meta name="description" content="This is a JSP example for a simple search page">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Success!</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div class="container" id="mainText">
			<c:choose>
				<c:when test="${message != null}">
					${message}
				</c:when>
				<c:otherwise>
					<p>The Database was updated with your movie!</p>
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>