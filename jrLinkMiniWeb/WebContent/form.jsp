<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<title>JEE - Mini Entity - Form</title>
<script type="text/javascript">
function validate() {
	res = true
	if (inpForm.inpKey && inpForm.inpKey.value == "") {
		res = false
		inpForm.inpKey.focus();
		alert("key is empty!")
	} else if (inpForm.inpValue.value == "") {
		res = false
		inpForm.inpValue.focus();
		alert("value is empty!")
	}
	return res;
}
</script>
</head>

<c:choose>
<c:when test="${not empty duplicate_key}">
	<body onLoad="alert('${duplicate_key} already exists!'); inpForm.inpKey.focus();">
</c:when>
<c:when test="${not empty entryKey}">
	<body onLoad="inpForm.inpValue.focus();">
</c:when>
<c:otherwise>
	<body onLoad="inpForm.inpKey.focus();">
</c:otherwise>
</c:choose>

	<h2>JEE - Mini Entity - Form</h2>
	<br />

	<form name="inpForm" method="post" action="manage?action=${nextAction}" accept-charset="UTF-8" onSubmit="return validate();">
	<table>	
		<tr>
			<td colspan="3"><a href="manage">back</a> to list</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td>key</td>
			<td>&nbsp;</td>
			<c:choose>
			<c:when test="${not empty entryKey}">
				<td>
					<input type="text" name="inpKeyD" value="${entryKey}" disabled />
					<input type="hidden" name="inpKey" value="${entryKey}" />
				</td>
			</c:when>
			<c:otherwise>
				<td><input type="text" name="inpKey" value="${entryKey}" /></td>
			</c:otherwise>
			</c:choose>
		</tr>		
		<tr>
			<td>value</td>
			<td>&nbsp;</td>
			<td><input type="text" name="inpValue" value="${entryValue}" /></td>
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