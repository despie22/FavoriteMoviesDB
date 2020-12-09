<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Movie List</title>
<meta name="description" content="This is a JSP that outputs every Movie
in our database to a web page">
<%@ include file="includes/styles.jsp" %>
</head>
<body onload="movieList()">
	<div class="container">
		<div class="hero-unit">
			<h1>Movie List</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>

		<div class ="container" id="mainText">
			<c:choose>
				<c:when test="${empty movieList}">
					<p>Sorry, the list of movies is empty.</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="movieList" items="${movieList}">
						<h2>${movieList.title}: ${movieList.year}</h2>
						<ul class="movieInfo">
							<li>Directed By: ${movieList.director}</li>
							<li>Length: ${movieList.lengthInMinutes} minutes</li>
							<li>Lead Star: ${movieList.actor}</li>
						</ul>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="includes/footer.jsp" %>

	</div>
	<%@ include file="includes/scripts.jsp" %>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js"></script>
	<script src="assets/js/movieList.js"></script>
</body>
</html>
