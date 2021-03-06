package exemplo04;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckCookieServlet extends HttpServlet {
  /**Process the HTTP Get request*/

  public void doGet(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    if (request.getParameter("flag") == null) {
        // the first request
        Cookie cookie = new Cookie("browserSetting", "on");
        response.addCookie(cookie);
        String nextUrl = request.getRequestURI() + "?flag=1";
        out.println("<META HTTP-EQUIV=Refresh CONTENT=0;URL="+ nextUrl
         +">");
    }
    else {
     // the second request
     Cookie[] cookies = request.getCookies();
     if (cookies != null) {
       int length = cookies.length;
       boolean cookieFound = false;
       for (int i=0; i<length; i++) {
         Cookie cookie = cookies[i];
         if (cookie.getName().equals("browserSetting") &&
           cookie.getValue().equals("on")) {
           cookieFound = true;
           break;
         }
       }
       if (cookieFound) {
         out.println("Your browser's cookie setting is on.");
       }
     }
     else {
         out.println("Your browser does not support cookies or" +
          " the cookie setting is off.");
     } 
    
    }
  }

  /**Process the HTTP Post request*/
  public void doPost(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    doGet(request, response);
  }
}