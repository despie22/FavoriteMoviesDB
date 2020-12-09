<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Web Programming: Populate Database</title>
<meta name="description" content="This is a JSP example for a simple search page">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Populate Database</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div class="container" id="mainText">
			<form action="ResetMovies" method="post">
				<p>Click on the Reset button to reset your movie database.</p>
				<p>Warning: Submitting this form will reset the database as it will
	 			contain northing.</p>
				<input type="submit" value="Reset!">
			</form>
		</div>
		<hr>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>