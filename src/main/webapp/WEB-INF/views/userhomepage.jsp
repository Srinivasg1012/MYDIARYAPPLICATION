<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHomepage</title>
<link  rel="stylesheet" href="<c:url value='/resources/styles/style.css'/>"/>
</head>
<body>
<h1>welcome <span style=color:blue;font-weight:bold;>${user.username}</span></h1>
<br><br>
<span style=color:red;float:right;width:50px;><a href="./signout">Signout</a></span><br><br>
<a href="./addentry">
<button type="button" style=color:white;background-color:skyblue;width:100px;float:right>Add entry</button>
</a>
<br><br>
<table border="1" style=width:99%;>
<tr>
<th colspan="1">Date</th>
<th colspan="3">Actions</th>
</tr>
<c:if test="${entrieslist.size()==0}">
<tr>
<td colspan="4" style=text-align:center;>No data found with this id</td>
</tr>
</c:if>

<c:forEach items="${entrieslist}" var="e">
<tr>
<td>
<fmt:formatDate value="${e.entrydate}"  pattern="dd/MM/yyyy" />

</td>
<td><a href="./viewentry?id=${e.id}">View</a></td>
<td><a href="./updateentry?id=${e.id}">Update</a></td>
<td><a href="./deleteentry?id=${e.id}">Delete</a></td>
</tr>
</c:forEach>






</table>
</body>
</html>