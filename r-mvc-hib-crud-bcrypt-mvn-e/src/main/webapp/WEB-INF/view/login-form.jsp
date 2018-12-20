<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<div id="nav-placeholder"></div>
<script src="simple-slider.js"></script>
<link href="simple-slider.css" rel="stylesheet" type="text/css" />

 <script>
$(function(){
  $("#nav-placeholder").load("page.jsp");
});
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<title>User Login</title>
	</head>

<body >
<div id="wrapper">
		<div id="header">
			
		</div>
	</div>

	<div id="container">
	<div class="jumbotron" >
			<h1>My bank</h1>

	</div>
	<h2>User Login</h2>
		<form:form action="validateUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" /></td>
					</tr>
				
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>


					<tr>
						<td><label></label></td>
						
						<td><input type="submit" value="Login" class="save" /></td>
					</tr>

				
				</tbody>
			

</div>
</div>


</form:form>

<c:if test="${not empty error}">
<p class="text-danger">
 ${error}</p>
</c:if>
</div>

</div>
</div>

</body>

</html>










