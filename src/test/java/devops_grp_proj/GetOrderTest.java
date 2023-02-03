package devops_grp_proj;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.devops.maven.ecplise.OrderGetServlet;

class GetOrderTest {
	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

	}

	@AfterEach
	void tearDown() throws Exception {
//		fail("Not yet implemented");

	}

	@Test
	void testGetConnection() throws Exception {
		fail("Not yet implemented");

	}

	@Test
	void testOrderGetServlet() throws Exception {
	    // Mock the request and response objects
	    HttpServletRequest request = mock(HttpServletRequest.class);  
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    

	    // Set up the response object to return the print writer
	    when(response.getWriter()).thenReturn(printWriter);
	    RequestDispatcher rd = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher(eq("/getOrders.jsp"))).thenReturn(rd);
	    // Call the doGet method on the servlet
	    new OrderGetServlet().listUsers(request, response); 


	    // Verify that the response was set to "Hello, World!"
//	    verify(response).setContentType("text/html");
	    printWriter.flush();
        String output = stringWriter.getBuffer().toString().trim();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new OrderGetServlet().listUsers(request, response);
	    assertEquals("3", outContent.toString().trim());
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testListUsers() {
		fail("Not yet implemented");
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
