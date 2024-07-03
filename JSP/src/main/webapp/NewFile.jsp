<%@page import="java.awt.geom.Path2D"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Marks List....!</h1>
<form action="logout">
<div id="hi">
<table border="1px">

<tr> <th>mark1 </th>
<th>mark2</th></tr>

<tr><td><%

HttpSession htp=request.getSession();
out.print(htp.getAttribute("mark1"));

%></td>

<td><%
out.print(htp.getAttribute("mark2"));
%></td></tr>
</table><br><br>
</div>
 
<button >Logout</button>

</form>
</body>
<style>
body{
background-image:url("Screenshot 2024-06-29 161412.png");
background-repeat:no-repeat;
background-attachment:fixed;
background-position: center center;
background-size:cover;
text-align: center;
background-color: grey;
padding-top: 300px;
}

table{
margin-left:700px;
left:500px;
}
button:hover{
color: silver;
}

</style>
</html>