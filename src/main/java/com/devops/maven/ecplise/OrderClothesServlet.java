package com.devops.maven.ecplise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderClothesServlet
 */
@WebServlet("/OrderClothesServlet")
public class OrderClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderClothesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			// Step 2: retrieve the four parameters from the request from the web form

			String n = request.getParameter("color");
			String p = request.getParameter("size");
			String e = request.getParameter("qty");
			// Step 3: attempt connection to database using JDBC, you can change the
			// username and password accordingly using the phpMyAdmin > User Account
			// dashboard
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clothing_db", "vishvah",
						"1234");
				// Step 4: implement the sql query using prepared statement
				// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
				try (PreparedStatement ps = con.prepareStatement("INSERT INTO clothing_db values(?,?,?)")) {
					// Step 5: parse in the data retrieved from the web form request into the
					// prepared statement accordingly
					ps.setString(1, n);
					ps.setString(2, p);
					ps.setString(3, e);
					// Step 6: perform the query on the database using the prepared statement
					int i = ps.executeUpdate(); 
					// Step 7: check if the query had been successfully execute, return “You are
					// successfully registered” via the response,
					if (i > 0) {
						PrintWriter writer = response.getWriter();
						writer.println("<h1>" + "You have successfully ordered!" + "</h1>");
						writer.close();
					}
				} catch (SQLException e2) {
					// Handle the exception here
				}

			}
			// Step 8: catch and print out any exception
			catch (Exception exception) {
				System.out.println(exception);
				out.close();
			}
			doGet(request, response);
			// TODO Auto-generated method stub
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
