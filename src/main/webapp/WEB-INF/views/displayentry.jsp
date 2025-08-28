<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view entry</title>
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
<span style=color:red;float:right;width:50px;><a href="./signout">Signout</a></span><br><br>

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
<br>
<div class="bodypart2">
<h1>VIEW ENTRY</h1><br><br><br>
<br><br><br>
<table>
<tr><td style=text-align:right;>Date:</td><td style=text-align:left;>${entry.entrydate}</td></tr>
<tr><td style=text-align:right;>Description:</td><td style=text-align:left;>${entry.description}</td></tr>

</table>

<a href="./userhome">
<button type="button">BACK TO HOMEPAGE
</button>
</a>
</div>
</div>






</body>
</html>