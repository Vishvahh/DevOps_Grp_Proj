package devops_grp_proj;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.devops.maven.ecplise.OrderGetServlet;
import com.devops.maven.ecplise.Prev_orders;

class GetOrdersTest {
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	private OrderGetServlet servlet;
	private Connection connection;

	@BeforeEach
	void setUp() throws Exception {
		servlet = new OrderGetServlet();
		connection = servlet.getConnection();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		connection.close();

	}

	@Test
	void testGetConnection() {
		try {
			assertEquals(true, connection.isValid(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	@Test
	void testOrderGetServlet() throws ServletException, IOException, SQLException {
		// Create an instance of the servlet to test
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO clothing_db (color, size, qty) VALUES ('red', 'S', '10')");

		ResultSet resultSet = statement.executeQuery("SELECT * FROM clothing_db");
		int count = 0;
		while (resultSet.next()) {
			count++; 
		}
		assertEquals(6, count, "Expected 4 record in the table but found " + count);
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
