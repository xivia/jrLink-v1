<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<title>JEE - Mini Entity - Form</title>
</head>
<body>
	<h2>JEE - Mini Entity - Form</h2>
	<br />

	<form name="inpForm" method="post" action="manage?action=${nextAction}" accept-charset="UTF-8">
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