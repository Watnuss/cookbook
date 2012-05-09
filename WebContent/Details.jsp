<%@page import="org.hibernate.criterion.Restrictions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hibernate.HibernateUtil"%>
<%@ page import="org.hibernate.*"%>
<%@ page import="java.util.List"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alle Rezepte anzeigen</title>
</head>
<body>
		<%
			SessionFactory sf = HibernateUtil.getSessionFactory();
			org.hibernate.Session hsession = null;
			Transaction transaction = null;

			try {
				hsession = sf.getCurrentSession();
				transaction = hsession.beginTransaction();
				Criteria c = hsession.createCriteria(Receipt.class)
						.add(Restrictions.idEq(Integer.parseInt(request.getParameter("id"))));
				
				List<Receipt> res = c.list();
				if(res.isEmpty()) {
					out.write("Receipt not found");
				}
				else {
					Receipt r = res.get(0);
					out.write("<table>");
					out.write("<tr><td>Titel</td><td><h2>" + r.getTitle() + "</h2></td></tr>");
					out.write("<tr><td>Dauer</td><td>" + r.getDuration() + "</td></tr>");
					out.write("<tr><td>Bemerkung</td><td>" + r.getNote() + "</td></tr>");
					out.write("<tr><td>Autor</td><td>" + r.getAuthor() + "</td></tr>");
					out.write("</table>");
					out.write("<h3>Equipment</h3>");
					out.write("<ul>");
					for(Equipment e : r.getEquipments()) {
						out.write("<li> " + e.getName());
					}
					out.write("</ul>");
					out.write("<h3>Ingredients</h3>");
					out.write("<ul>");
					for(Ingredient i : r.getIngredients()) {
						out.write("<li> " + i.getName());
					}
					out.write("</ul>");
				}
				//System.out.println(r.toString());
				transaction.commit();
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
		%>
		<form method="POST" action="Controller">
			<input type="submit" name="backToView" value="Zurück">
			<input type="submit" name="addToBook" value="Zum Kochbuch hinzufügen">
		</form>
</body>
</html>