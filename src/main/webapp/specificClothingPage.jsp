<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css1.css" rel="stylesheet" type="text/css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Specific Clothing</title>
</head>
<body>
<jsp:include page="index.jsp" />

<img style="margin-left:50px;margin-top:50px;width:30%" src="image.png">
<div style=" float:right;margin-right:600px">
<div class="tshirt" style="postion:relative;left:20px;"><p style="margin-top:50px;font-size:2vw;">Generic White T-shirt</p>
<p class="price" style="font-size:1.5vw">$12.90</p>
<p style="opacity:0.5;">100% premium cotton with 
minimal wrinkles</p>

</div>
<form action="OrderClothesServlet" method="post"> 
Size:<select name="color">
<option>Red</option>
<option>Blue</option>

</select>

<br>
<div style="margin-top:30px"></div>


Size:<select name="size">
<option>S</option>
<option>M</option>
<option>L</option>

</select>

<br>


<label for="quantity" style="font-size:2vw">Quantity</label>
<br>

<select id="quantity" name="qty">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4" selected>4</option>
</select>
<br>
<div style="margin-bottom:20px"></div>
<button style="height:50px;width:200px;font-size:1.5vw" class="button3" type="submit" value="Call Servlet">Add to cart</button>
</form>

</div>

<p style="background-color:red;width:200px;font-size:1.5vw;color:white;margin-left:100px;margin-top:20px;text-align:center">Row - 2, Aisle - 1</p>
<div class="row">
<div class="container">
<h3 class="text-center">List of Users</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-
success">Add New User</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Color</th>
<th>Size</th>
<th>Qty</th>

</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
<tbody>
<c:forEach var="user" items="${listUsers}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${user.color}" />
</td>
<td>
<c:out value="${user.size}" />
</td>
<td>
<c:out value="${user.qty}" />
</td>

<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?name=<c:out value='${user.name}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?name=<c:out
value='${user.name}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>