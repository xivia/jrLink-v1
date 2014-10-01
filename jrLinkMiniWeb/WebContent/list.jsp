<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>JEE - Mini Entity - List</title>
</head>
<body>
	<h2>JEE - Mini Entity - List</h2>
	<br />
	
	<table>
	<tr>
		<td colspan="4"><a href="manage?action=new">new</a> record</td>
		<td colspan="3">&nbsp;</td>
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