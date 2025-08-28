<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update entry</title>
<link  rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>"/>
</head>

<body>

<div class="header">
<div class="first">
<img src="<c:url value="/resources/images/diary2.png"/>" width="60" height="60" />
</div>
<div class="second">MyDiary App</div>
</div>
<br><br>
<hr>
<h1>Welcome 
<span style=color:red;>
${user.username}
</span>

</h1>
<div class="bodypart">
<div class="bodypart1">
<img src="<c:url value="/resources/images/diary2.png"/>"/>
</div>
<span style=color:red;float:right;width:50px;><a href="./signout">Signout</a></span><br><br>



<br>
<div class="bodypart2">
<h1>UPDATE ENTRY</h1><br><br><br>
<form action="./processentryupdate" method="post">
<label>date:</label><input type="text" name="entrydate" class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}"  pattern="yyyy-MM-dd" />" readonly/><br><br>
<label>description:</label><br>
<textarea rows="10" cols="20" name="description">
${entry.description}
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<input type="hidden" name="id" value="${entry.id}">

<br>

<button type="submit">UPDATE ENTRY</button>
</form>
</div>
</div>






</body>
</html>