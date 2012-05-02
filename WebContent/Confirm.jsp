<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bestätigung Ihres Rezeptes</title>
</head>
<body>
	<jsp:useBean id="receipt" class="model.Receipt" scope="session" />
	<jsp:setProperty property="*" name="receipt"/>
	<form method="POST" action="Controller">
		<table>
			<tr><td>Rezeptname:</td><td><input type="text" name="title" value="<jsp:getProperty property="title" name="receipt"/>"></td></tr>
			<tr><td>Author:</td><td><input type="text" name="author" value="<jsp:getProperty property="author" name="receipt"/>"></td></tr>
			<tr><td>Beschreibung:</td><td><input type="text" name="description" value="<jsp:getProperty property="description" name="receipt"/>"></td></tr>
			<tr><td>Dauer:</td><td><input type="text" name="duration" value="<jsp:getProperty property="duration" name="receipt"/>"></td></tr>
			<tr><td>Schwierigkeit:</td><td><input type="text" name="degree" value="<jsp:getProperty property="degree" name="receipt"/>"></td></tr>
			<tr><td>Bemerkung:</td><td><input type="text" name="note" value="<jsp:getProperty property="note" name="receipt"/>"></td></tr>
		</table>
		<input type="submit" name="confirmReceipt" value="Bestaetigung">
		<input type="submit" name="addIngredient" value="Zutaten hinzufuegen">
		<input type="submit" name="addEquipment" value="Hilfsmittel hinzufuegen">
	</form>
</body>
</body>
</html>