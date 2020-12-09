<!DOCTYPE html>
<html>
<head>
<title>Add New Movie</title>
<meta name="description" content="This jsp example demonstrates how to use a form
to add a new person to a database.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="her-unit">
			<h1>Add New Movie</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div class="container" id="mainText">
			<form action="AddMovie" method="post">
				<label for="title"><strong>Title: </strong></label>
				<input name="title"><br>

				<label for="director"><strong>Director: </strong></label>
				<input name="director"><br>
				
				<label for="lengthInMinutes"><strong>Length In Minutes: </strong></label>
				<input name="lengthInMinutes"><br>
				
				<label for="actor"><strong>Lead Star: </strong></label>
				<input name="actor"><br>
				
				<label for="year"><strong>Year Released: </strong></label>
				<input name="year"><br>
				
				<input type="submit" value="Add Movie" id="submit">
			</form>
		</div>
		<hr>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>