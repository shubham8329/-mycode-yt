package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DateTimeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setDateHeader("Refresh", 1);
		PrintWriter writer = resp.getWriter();
		Date date = new Date();
		writer.println("<h1>" +date+"</h1>");
	}
}
