package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.utility.TrainUtil;

@SuppressWarnings("serial")
@WebServlet("/sessionstatus")
public class SessionStatus extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		try {
			pw.println("<html><body>");
			pw.println("<h2>Session Status Check</h2>");
			
			// Check session attributes
			String userName = TrainUtil.getCurrentUserName(req);
			String userEmail = TrainUtil.getCurrentUserEmail(req);
			
			pw.println("<p><strong>Current User Name:</strong> " + (userName != null ? userName : "Not logged in") + "</p>");
			pw.println("<p><strong>Current User Email:</strong> " + (userEmail != null ? userEmail : "Not logged in") + "</p>");
			
			// Check session info
			pw.println("<p><strong>Session ID:</strong> " + req.getSession().getId() + "</p>");
			pw.println("<p><strong>Session Max Inactive Interval:</strong> " + req.getSession().getMaxInactiveInterval() + " seconds</p>");
			pw.println("<p><strong>Session Creation Time:</strong> " + new java.util.Date(req.getSession().getCreationTime()) + "</p>");
			pw.println("<p><strong>Session Last Accessed:</strong> " + new java.util.Date(req.getSession().getLastAccessedTime()) + "</p>");
			
			// Check cookies
			pw.println("<h3>Cookies:</h3>");
			if (req.getCookies() != null) {
				for (javax.servlet.http.Cookie cookie : req.getCookies()) {
					pw.println("<p>" + cookie.getName() + " = " + cookie.getValue() + " (Max Age: " + cookie.getMaxAge() + ")</p>");
				}
			} else {
				pw.println("<p>No cookies found</p>");
			}
			
			pw.println("<p><a href='UserLogin.html'>Login</a> | <a href='AutoLogoutTest.html'>Auto Logout Test</a></p>");
			pw.println("</body></html>");
		} catch (Exception e) {
			pw.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}
