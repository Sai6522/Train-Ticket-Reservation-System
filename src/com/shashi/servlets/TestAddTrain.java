package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainBean;
import com.shashi.service.TrainService;
import com.shashi.service.impl.TrainServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/testaddtrain")
public class TestAddTrain extends HttpServlet {

	private TrainService trainService = new TrainServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		try {
			pw.println("<html><body>");
			pw.println("<h2>Add Train Test</h2>");
			
			// Get parameters
			String trainno = req.getParameter("trainno");
			String trainname = req.getParameter("trainname");
			String fromstation = req.getParameter("fromstation");
			String tostation = req.getParameter("tostation");
			String available = req.getParameter("available");
			String fare = req.getParameter("fare");
			
			pw.println("<p>Received Parameters:</p>");
			pw.println("<p>Train No: " + trainno + "</p>");
			pw.println("<p>Train Name: " + trainname + "</p>");
			pw.println("<p>From: " + fromstation + "</p>");
			pw.println("<p>To: " + tostation + "</p>");
			pw.println("<p>Seats: " + available + "</p>");
			pw.println("<p>Fare: " + fare + "</p>");

			TrainBean train = new TrainBean();
			train.setTr_no(Long.parseLong(trainno));
			train.setTr_name(trainname.toUpperCase());
			train.setFrom_stn(fromstation.toUpperCase());
			train.setTo_stn(tostation.toUpperCase());
			train.setSeats(Integer.parseInt(available));
			train.setFare(Double.parseDouble(fare));

			String message = trainService.addTrain(train);
			pw.println("<p><strong>Add Result: " + message + "</strong></p>");
			
			pw.println("<p><a href='QuickAddTest.html'>Back to Add Test Page</a></p>");
			pw.println("</body></html>");
		} catch (Exception e) {
			pw.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}
}
