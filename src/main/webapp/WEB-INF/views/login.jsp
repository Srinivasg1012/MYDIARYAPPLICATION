<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
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
<div class="bodypart">
<div class="bodypart1">
<img src="<c:url value="/resources/images/diary2.png"/>"/>
</div>
<br>
<div class="bodypart2">
<h1>LOGIN HERE</h1><br><br><br>
<form action="authenticate" method="post">
<label>username:</label><input type="text" name="username" class="formcontrol"/><br><br>
<label>password:</label><input type="password" name="password" class="formcontrol"/><br><br>
<button type="submit">LOGIN</button>
</form>
<br><br>
New User ?<a href="./register"> Register Here</a>

</div>
</div>






</body>
</html>