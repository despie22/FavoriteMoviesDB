<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Web Programming: Error</title>
<meta name="description" content="This is a JSP example that demonstrates an error response for whenever we encounter a problem in our application." />
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Error</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div class="container" id="mainText">
			<p>We ran into a wall.</p>
			<c:choose>
				<c:when test="${message != null}">
					${message}
				</c:when>
				<c:otherwise>
					<h2>Error Details</h2>
					<p>Type: ${pageContext.exception["class"] }</p>
					<p>Message: ${pageContext.exception.message }</p>
				</c:otherwise>
			</c:choose>	
		</div>
		
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>