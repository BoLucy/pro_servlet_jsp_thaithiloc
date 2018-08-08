<%@page import="pro_servlet_jsp_thaithiloc.beans.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listdb</title>
</head>
<body>
	<h1>List User use Java in JSP</h1>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Birthday</td>
			<td>BirthPlace</td>
		</tr>
		<%
			List<UserModel> listUser = (List<UserModel>) (request.getAttribute("listUser"));
			for (UserModel user : listUser) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getBirthday()%></td>
			<td><%=user.getBirthPlace()%></td>
		</tr>

		<%
			}
		%>
	</table>

	<h1>List User use JSTL</h1>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Birthday</td>
			<td>BirthPlace</td>
		</tr>
		<c:forEach var="user" items = "${listUser}">
			<tr>
				<td><c:out value="${user.id}"></c:out></td>
				<td><c:out value="${user.name}"></c:out></td>
				<td><c:out value="${user.birthday}"></c:out></td>
				<td><c:out value="${user.birthPlace}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>