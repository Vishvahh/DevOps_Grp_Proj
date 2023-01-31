package com.devops.maven.ecplise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class OrderGetServlet
 */
@WebServlet("/OrderGetServlet")
public class OrderGetServlet extends HttpServlet {
	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3307/clothing_db";
	private String jdbcUsername = "vishvah";
	private String jdbcPassword = "1234";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database

	public static final String SELECT_ALL_USERS = "SELECT * FROM clothing_db";

	private static final long serialVersionUID = 1L;

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderGetServlet() { 
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
//		String action = request.getServletPath();
		try {
//			switch (action) { 
//			case "/insert":
//				break;
//			case "/delete":
//				break;
//			case "/edit":
//				break; 
//			case "/update":
//				break;
//			default:
//				listUsers(request, response);
//				break; 
//			} 
			listUsers(request, response);

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Prev_orders> users = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String color = rs.getString("color");
				String size = rs.getString("size");
				String qty = rs.getString("qty");
				users.add(new Prev_orders(color, size, qty));  
			}
			System.out.println("got items"); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listUsers", users);
		request.getRequestDispatcher("/specificClothingPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
