package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredient;
import model.Receipt;
import model.Equipment;

public class Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String destination = "";
		Receipt receipt;

		if (req.getParameter("enterReceipt") != null) {
			destination = "Confirm.jsp";
		} else if (req.getParameter("addIngredient") != null) {
			destination = "AddIngredient.jsp";
		} else if (req.getParameter("confirmIngredient") != null) {
			destination = "AddIngredient.jsp";
		} else if (req.getParameter("finishIngredient") != null) {
			destination = "Confirm.jsp";
		} else if (req.getParameter("addEquipment") != null) {
			destination = "AddEquipment.jsp";
		} else if (req.getParameter("confirmEquipment") != null) {
			destination = "AddEquipment.jsp";
		} else if (req.getParameter("finishEquipment") != null) {
			destination = "Confirm.jsp";
		} else if (req.getParameter("confirmReceipt") != null) {
			destination = "Edit.jsp";
		} else {
			destination = "Error.jsp";
		}
		System.out.println("destination: " + destination);

		switch (destination) {

		case "Confirm.jsp":
			if (req.getSession().getAttribute("receipt") != null) {
				receipt = (Receipt) req.getSession().getAttribute("receipt");
				System.out.println("Found Receipt in session: "
						+ receipt.toString());
			} else {
				receipt = createReceipt(req);
				System.out.println("Stored Receipt in session: "
						+ receipt.toString());
				req.getSession().setAttribute("receipt", receipt);
			}
			break;
		case "AddIngredient.jsp":
			if (req.getParameter("name") != null) {
				receipt = (Receipt) req.getSession()
						.getAttribute("receipt");
				System.out.println("Found Receipt in session: "
						+ receipt.toString());
				Ingredient i = new Ingredient();
				i.setAmount(Float.parseFloat(req.getParameter("amount")));
				i.setName(req.getParameter("name"));
				i.setUnit(req.getParameter("unit"));
				i.setReceipt(receipt);
				receipt.addIngredient(i);
				System.out.println("Stored Receipt in session: "
						+ receipt.toString());
				req.getSession().setAttribute("receipt", receipt);
			}
			break;
		case "AddEquipment.jsp":
			if (req.getParameter("name") != null) {
				receipt = (Receipt) req.getSession()
						.getAttribute("receipt");
				System.out.println("Found Receipt in session: "
						+ receipt.toString());
				
				Equipment e = new Equipment();
				e.setName(req.getParameter("name"));
				e.setReceipt(receipt);
				receipt.addEquipment(e);
				System.out.println("Stored Receipt in session: "
						+ receipt.toString());
				req.getSession().setAttribute("receipt", receipt);
			}
			break;
		case "Edit.jsp":
			/* TODO add a finish/"thank you" page */
			// RecipeExporter.export(receipt);
			System.out.println("Saving Receipt: "
					+ req.getSession().getAttribute("receipt"));
			req.getSession().removeAttribute("receipt");
			destination = "Edit.jsp";
			break;
		}

		getServletContext().getRequestDispatcher("/" + destination).forward(
				req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("TestTest");
	}

	private Receipt createReceipt(HttpServletRequest req) {
		String author, title, description, note;
		int duration, degree;
		Receipt receipt = new Receipt();

		if (req.getParameter("author") != null) {
			author = req.getParameter("author");
			receipt.setAuthor(author);
		}

		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
			receipt.setTitle(title);
		}

		if (req.getParameter("description") != null) {
			description = req.getParameter("description");
			receipt.setDescription(description);
		}

		if (req.getParameter("note") != null) {
			note = req.getParameter("note");
			receipt.setNote(note);
		}

		if (req.getParameter("duration") != null) {
			try {
				duration = Integer.parseInt(req.getParameter("duration"));
				receipt.setDuration(duration);
			} catch (NumberFormatException e) {
				return null;
			}
		}

		if (req.getParameter("degree") != null) {
			try {
				degree = Integer.parseInt(req.getParameter("degree"));
				receipt.setDegree(degree);
			} catch (NumberFormatException e) {
				return null;
			}
		}

		return receipt;
	}

}
