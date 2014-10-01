<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<title>JEE - Mini Entity - List</title>
</head>
<body>
	<h2>JEE - Mini Entity - List</h2>
	<br />
	
	<table>
	<tr>
		<td colspan="7"><a href="manage">refresh</a> list &nbsp;|&nbsp; <a href="manage?action=new">new</a> record</td>
	</tr>
	<tr>
		<td colspan="7">&nbsp;</td>
	</tr>
	<tr>
		<td>key</td>
		<td>&nbsp;</td>
		<td>value</td>
		<td>&nbsp;</td>
		<td colspan="3">action</td></tr>
	<c:forEach var="item" items="${resultList}">
  		<tr>
 	 		<td>${item.key}</td>
 	 		<td>&nbsp;</td>
  			<td>${item.value}</td>
  			<td>&nbsp;</td>
  			<td><a href="manage?action=edit&key=${item.key}">edit</a></td>
  			<td>&nbsp;</td>
  			<td><a href="manage?action=delete&key=${item.key}">delete</a></td>
  		</tr>
	</c:forEach>
	</table>
	
	<br />
</body>
</html>