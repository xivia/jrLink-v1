<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>JEE - Mini Entity - Form</title>
</head>
<body>
	<h2>JEE - Mini Entity - Form</h2>
	<br />

	<form name="inpForm" method="post" action="manage?action=${nextAction}">
	<input type="hidden" name="inpKey" value="${entryKey}" />
	<table>	
	<tr>
		<td colspan="3"><a href="manage">back</a> to list</td>
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
		<c:if test="${not empty entryKey}">
		<tr>
			<td>key</td>
			<td>&nbsp;</td>
			<td>${entryKey}</td>
		</tr>		
		</c:if>
		<tr>
			<td>value</td>
			<td>&nbsp;</td>
			<td><input type="text" name="inpValue" value="${entryValue}"/></td>
		</tr>	
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td><input type="submit" name="inpSubmitButton" value="save" /></td>
		</tr>
	</table>
	</form> 
	
	<br />
</body>
</html>