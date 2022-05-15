
<%@ page import="model.users"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Componets/jquery-3.2.1.min.js"></script>
<script src="Componets/user.js"></script>
 


</head>
<body>
<h1>User Management</h1>
   <form id="formItem" name="formItem" method="post" action="user.jsp">
   
 
		 userID:
		<input id="ID" name="ID" type="text"
		 class="form-control form-control-sm">
		<br> userName:
		<input id="Name" name="Name" type="text"
		 class="form-control form-control-sm">
		<br> User Phone No:
		<input id="Ph_No" name="Ph_No" type="text"
		 class="form-control form-control-sm">
		<br> Email Address:
		<input id="Email" name="Email" type="text"
		 class="form-control form-control-sm">
		<br>
		
		<input id="btnSave" name="btnSave" type="button" value="Save"
		 class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
  </form>

	<div id="alertSuccess" class="alert alert-success"></div>
    <div id="alertError" class="alert alert-danger"></div>
	
		<br> 
		<div id="divItemsGrid">
		 <%
		 users itemObj = new users();
		 		 out.print(itemObj.readUsers());
		 %>
		</div>

 
 
 
    </div>

</div>


</body>
</html>
