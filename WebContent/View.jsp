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
				Criteria c = hsession.createCriteria(Receipt.class);
				
				List<Receipt> res = c.list();
				if (!res.isEmpty()) {
					out.write("<ul>");
					out.write("<h2>Rezepte</h2>");
					for (Receipt r : res) {
						out.write("<li>" + r.getTitle()
								+ " <a href=\"Details.jsp?id="
								+ r.getID() + "\">Details</a> <a href=\"Controller?addToCookbook&id="
								+ r.getID() + "\">Zum Kochbuch hinzufügen</a>");
					}
					out.write("</ul>");
				}
				//System.out.println(r.toString());
				transaction.commit();
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
		%>
		<a href="ViewCookbook.jsp">Kochbuch</a>
</body>
</html>