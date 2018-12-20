<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<div id="nav-placeholder"></div>
<script src="simple-slider.js"></script>
<link href="simple-slider.css" rel="stylesheet" type="text/css" />

<script>
	$(function() {
		$("#nav-placeholder").load("page.jsp");
	});
</script>
<title>List Customers</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!-- 
Refresh page every 5 seconds -->
<script type="text/javascript">
	setInterval("my_function();", 10000);

	function my_function() {
		window.location = location.href;
	}
</script>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Table</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Customer" class="btn btn-danger"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" /><br/>
			<div class="w3-container">
 <a href="${pageContext.request.contextPath}/login/loginform"
						class="w3-button w3-black">LOGOUT</a>
				</div>
			</div>

			<!--  add our html table here -->
			<table border="1" cellpadding="5">

				<tr>
					<th bgcolor="gray">Customer Name</th>
					<th bgcolor="gray">Customer Address</th>
					<th bgcolor="gray">Customer Pin Code</th>
					<th bgcolor="gray">Customer Email</th>
					<th bgcolor="gray">Contact Number</th>
					<th bgcolor="gray">Registration Date</th>
					<th bgcolor="gray">Created By</th>
					<th bgcolor="gray">Modified Date
					<th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerCode" value="${tempCustomer.code}" />
					</c:url>


					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerCode" value="${tempCustomer.code}" />
					</c:url>
					<tr>
						<td>${tempCustomer.customerName}</td>
						<td>${tempCustomer.customerAddress}</td>
						<td>${tempCustomer.customerPinCode}</td>
						<td>${tempCustomer.customerEmail}</td>
						<td>${tempCustomer.contactNumber}</td>
						<td>${tempCustomer.registrationDate}</td>
						<td>${tempCustomer.createdBy}</td>
						<td>${tempCustomer.modifiedDate}</td>

						<td>
							<!-- display the update link --> <a href="${updateLink}"
							onclick="if (!(confirm('Are you sure you want to edit this customer?'))) return false"
							class="btn btn-primary btn-sm">Edit</a> <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"
							class="btn btn-danger btn-sm">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>


		</div>

	</div>


</body>

</html>









