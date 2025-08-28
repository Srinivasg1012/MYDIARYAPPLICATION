<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add entry</title>
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
<span style=color:red;float:right;width:50px;><a href="./signout">Signout</a></span><br><br>
<br>
</h1>
<div class="bodypart">
<div class="bodypart1">
<img src="<c:url value="/resources/images/diary2.png"/>"/>
</div>

<br>
<div class="bodypart2">
<h1>ADD ENTRY</h1><br><br><br>
<form action="./saveentry" method="post">
<label>date:</label><input type="date" name="entrydate" class="formcontrol"/><br><br>
<label>description:</label><br>
<textarea rows="10" cols="20" name="description">
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<br>

<button type="submit">SAVE ENTRY</button>
</form>
</div>
</div>






</body>
</html>