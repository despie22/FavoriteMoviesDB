<!DOCTYPE html>
<html>
<head>
<meta name="description" content="This is a servlet example that demonstrate how to use IO to output the contents of an Excel spreadsheet to a web page." />
<%@ include file="includes/styles.jsp" %>
<title>Favorite Movies</title>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Favorite Movies</h1>
		</div>

		<%@ include file="includes/navigation.jsp" %>

		<div class="container" id="mainText">
			<p>Welcome back to your favorite movies database!</p><br>
			<p>You can view you movies by Unsorted, Title, Director, Year, Length or Lead Star.</p><br>
			<p>You can search by Title, Director, Year or Lead Star.</p><br>
			<p>You can also Add to your Favorite Movies or Reset your Favorite Movies.</p>
		</div>

		<hr />
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>


</body>
</html>
