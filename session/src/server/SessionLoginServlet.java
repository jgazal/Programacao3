package server;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class SessionLoginServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
 
    sendLoginForm(response, false);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    if (login(userName, password)) {
      //send HttpSession Object to the browser
      HttpSession session = request.getSession(true);
      session.setAttribute("loggedIn", new String("true"));
      response.sendRedirect("index");
    }
    else {
      sendLoginForm(response, true);
    }
  }

  private void sendLoginForm(HttpServletResponse response, boolean
    withErrorMessage)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Login</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<CENTER>");
    if (withErrorMessage) {
      out.println("Login failed. Please try again.<BR>");
      out.println("If you think you have entered the correct user name" + 
        " and password, the cookie setting in your browser might be off.");
    }
    out.println("<BR>");
    out.println("<BR><H2>Login Page</H2>");
    out.println("<BR>");
    out.println("<BR>Please enter your user name and password.");
    out.println("<BR>");
    out.println("<BR><FORM METHOD=POST>");
    out.println("<TABLE>");
    out.println("<TR>");
    out.println("<TD>User Name:</TD>");
    out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
    out.println("</TR>");
    out.println("<TR>");
    out.println("<TD>Password:</TD>");
    out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
    out.println("</TR>");
    out.println("<TR>");
    out.println("<TD ALIGN=RIGHT COLSPAN=2>");
    out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
    out.println("</TR>");
    out.println("</TABLE>");
    out.println("</FORM>");
    out.println("</CENTER>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public static boolean login(String userName, String password) {
    try {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/autenticacao?user=root&password=root");
		//Class.forName("org.postgresql.Driver");
		//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/autenticacao", "postgres", "");
		Statement s = con.createStatement();
		String sql = "SELECT usuario FROM usuarios" + " WHERE usuario='" + userName + "'" + " AND senha='"
				+ password + "'";
		ResultSet rs = s.executeQuery(sql);
		if (rs.next()) {
			rs.close();
			s.close();
			con.close();
			return true;
		}
		rs.close();
		s.close();
		con.close();
	} catch (ClassNotFoundException e) {
		System.out.println(e.toString());
	} catch (SQLException e) {
		System.out.println(e.toString());
	} catch (Exception e) {
		System.out.println(e.toString());
	}
	return false;
  }
}