package server;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Content2Servlet extends HttpServlet {

  public String loginUrl = "login";
  
    /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {

    HttpSession session = request.getSession();
    if (session == null)
      response.sendRedirect(loginUrl);
    else {
      String loggedIn = (String) session.getAttribute("loggedIn");

      if (loggedIn == null || !loggedIn.equals("true"))
        response.sendRedirect(loginUrl);
    }

   // This is an authorized user, okay to display content
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Welcome</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("Welcome.");
    out.println("</BODY>");
    out.println("</HTML>");
  }

  /**Process the HTTP Post request*/
  public void doPost(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {

    doGet(request, response);
  }
}