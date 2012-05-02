<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rezepteingabe</title>
</head>
<body>
	<jsp:useBean id="receipt" class="model.Receipt" scope="session" />
	<jsp:setProperty property="*" name="receipt"/>
	<form method="POST" action="Controller">
		<table>
			<tr><td>Rezeptname:</td><td><input type="text" name="title"></td></tr>
			<tr><td>Author:</td><td><input type="text" name="author"></td></tr>
			<tr><td>Beschreibung:</td><td><input type="text" name="description"></td></tr>
			<tr><td>Dauer:</td><td><input type="text" name="duration"></td></tr>
			<tr><td>Schwierigkeit:</td><td><input type="text" name="degree"></td></tr>
			<tr><td>Bemerkung:</td><td><input type="text" name="note"></td></tr>
		</table>
		<input type="submit" name="enterReceipt" value="Weiter">
	</form>
</body>
</html>