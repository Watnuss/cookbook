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
	<table>
		<%
			SessionFactory sf = HibernateUtil.getSessionFactory();
			org.hibernate.Session hsession = null;
			Transaction transaction = null;

			try {
				hsession = sf.getCurrentSession();
				transaction = hsession.beginTransaction();
				//List<Receipt> result = (List<Receipt>) session.createQuery("from receipt").list();
				//for(Receipt r : result) {
				//	System.out.println(r.toString());
				//}
				//Receipt r = (Receipt) session.load(Receipt.class, 13);
				Criteria c = hsession.createCriteria(Receipt.class);
				List<Receipt> res = c.list();
				if (!res.isEmpty()) {
					out.write("<table>");
					out.write("<tr><td>Titel</td><td>Autor</td><td>Beschreibung</td><td>Schwierigkeit</td><td>Dauer</td><td>Bemerkung</td></tr>");
					for (Receipt r : res) {
						out.write("<tr><td>" + r.getTitle() + "</td><td>" + r.getAuthor() + "</td><td>" + r.getDescription() + "</td><td>" + r.getDegree() + "</td><td>" + r.getDescription() + "</td><td>" + r.getNote() + "</td></tr>");
					}
					out.write("</table>");
				}
				//System.out.println(r.toString());
				transaction.commit();
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
		%>
	</table>
</body>
</html>