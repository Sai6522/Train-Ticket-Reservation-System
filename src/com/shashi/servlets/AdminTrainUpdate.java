package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainBean;
import com.shashi.service.TrainService;
import com.shashi.service.impl.TrainServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/adminupdatetrain")
public class AdminTrainUpdate extends HttpServlet {

	private TrainService trainService = new TrainServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		try {
			String trainNo = req.getParameter("trainnumber");
			if (trainNo == null || trainNo.trim().isEmpty()) {
				RequestDispatcher rd = req.getRequestDispatcher("AdminUpdateTrain.html");
				rd.include(req, res);
				pw.println("<div class='tab' style='color:red;'>Please enter a valid train number</div>");
				return;
			}
			
			TrainBean train = trainService.getTrainById(trainNo);
			if (train != null) {
				RequestDispatcher rd = req.getRequestDispatcher("AdminHome.html");
				rd.include(req, res);
				pw.println("<div class='tab'>Train Schedule Update</div>");
				pw.println("<div class='tab'>" + "<table><form action='updatetrainschedule' method='post'>"
						+ "<tr><td>Train No :</td><td><input type='number' name='trainno' value='" + train.getTr_no()
						+ "' readonly></td></tr>" + "<tr><td>Train Name :</td><td><input type='text' name='trainname' value='"
						+ train.getTr_name() + "' required></td></tr>"
						+ "<tr><td>From Station :</td><td><input type='text' name='fromstation' value='"
						+ train.getFrom_stn() + "' required></td></tr>"
						+ "<tr><td>To Station :</td><td><input type='text' name='tostation' value='" + train.getTo_stn()
						+ "' required></td></tr>"
						+ "<tr><td>Available seats:</td><td><input type='number' name='available' value='"
						+ train.getSeats() + "' required min='1'></td></tr>"
						+ "<tr><td>Fare (INR) :</td><td><input type='number' step='0.01' name='fare' value='" + train.getFare()
						+ "' required min='0'></td></tr>"
						+ "<tr><td></td><td><input type='submit' name='submit' value='Update Train Schedule'></td></tr>"
						+ "</form></table>" + "</div>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("AdminUpdateTrain.html");
				rd.include(req, res);
				pw.println("<div class='tab' style='color:red;'>Train Not Available - Please check train number</div>");
			}
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("AdminUpdateTrain.html");
			rd.include(req, res);
			pw.println("<div class='tab' style='color:red;'>Error: " + e.getMessage() + "</div>");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}
}
