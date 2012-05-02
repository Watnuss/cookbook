<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zubehöreingabe</title>
</head>
<body>
	<form method="POST" action="Controller">
		<table>
			<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
		</table>
		<input type="submit" name="confirmEquipment" value="Hinzufuegen">
		<input type="submit" name="finishEquipment" value="Fertig">
	</form>
</body>
</html>