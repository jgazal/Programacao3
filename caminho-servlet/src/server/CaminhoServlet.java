package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CaminhoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String current2 = getServletContext().getRealPath("/");
		String current = new java.io.File(".").getCanonicalPath();
		String fileSeparator = System.getProperty("file.separator");
		out.println("Current dir:" + current);
		out.println("Context dir:" + current2);
		out.println("file Separator:" + fileSeparator);
	}
}