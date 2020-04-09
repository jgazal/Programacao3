import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HttpRequestDemoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse
		response) throws ServletException, IOException {

		String[] values = request.getParameterValues("favoriteMusic");
		response.setContentType("text/html");

        PrintWriter out = response.getWriter(); 
		if (values != null ) {
            int length = values.length;

            out.println( "<?xml version = \"1.0\"?>" );
            out.printf( "%s%s%s", "<!DOCTYPE html PUBLIC", 
                " \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
                " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" );
            out.println( "<html xmlns = \"http://www.w3.org/1999/xhtml\">" );
            out.println( "<head>" );
            out.println("<title>HttpRequestDemoServlet</title>" );
            out.println( "</head>" );
            out.println( "<body>" );
			out.println("<br>You have selected: ");
            
            for (int i=0; i<length; i++) {
				out.println("<br>" + values[i]);
			}
            out.println( "</body>" );
            out.println( "</html>" );
            out.close(); 
        }
    }
}
