<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hibernate.HibernateUtil"%>
<%@ page import="org.hibernate.*"%>
<%@ page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alle Rezepte anzeigen</title>
</head>
<body>
	<%
		int count = 0;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		org.hibernate.Session hsession = null;
		Transaction transaction = null;

		try {
			hsession = sf.getCurrentSession();
			transaction = hsession.beginTransaction();

			out.write("<ul>");
			String ids = (String) session.getAttribute("cookbook");
			for (String id : ids.split(",")) {
				count++;
				Criteria c = hsession.createCriteria(Receipt.class).add(
						Restrictions.idEq(Integer.parseInt(id)));
				List<Receipt> res = c.list();
				if (!res.isEmpty()) {
					out.write("<li>" + res.get(0).getTitle());
				}
			}

			out.write("</ul>");
			transaction.commit();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	%>
	<a href="View.jsp">Zurück</a>
	<a href="Controller?clearCookbook">Leeren</a>
	<a onclick="alert('Es werden <%=count%> Rezepte gedruckt')">Print</a>
</body>
</html>