<!doctype html>
<html>

<head>
<meta name="description"
	content="This is a JSP example for a simple search page." />
<%@ include file="includes/styles.jsp"%>
<title>Search Tarantino's Movies</title>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Search</h1>
		</div>

		<%@ include file="includes/navigation.jsp"%>

		<div class="container" id="mainText">
			<form action="Search" method="post">
				<label for="search"><strong>Search by: </strong> 
				<select name="dropBox" id="dropBox">
						<option value="title">Title</option>
						<option value="director">Director</option>
						<option value="year">Year</option>
						<option value="actor">Lead Star</option>
				</select> 
				<input name="search" id="searchBar"> <input type="submit" value="Search!" id="searchButton">
				</label>
			</form>
		</div>

		<hr />
		<%@ include file="includes/footer.jsp"%>
	</div>
	<%@ include file="includes/scripts.jsp"%>


</body>

</html>