package exemplo05;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckCookieServlet1 extends HttpServlet {
	/** Process the HTTP Get request */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nextUrl = request.getRequestURI();
		String cont = request.getParameter("cont");
		
		int count = cont != null ? Integer.parseInt(cont) : 0;
		count++;
		nextUrl = "?cont=" + count;

		System.out.println("Passei");
		out.println("<META HTTP-EQUIV=Refresh CONTENT=1;URL=" + nextUrl + ">");
		out.printf
		("<body><h1>Olá estou passando: cont: %d</h1></body>", count);
	}

	/** Process the HTTP Post request */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}