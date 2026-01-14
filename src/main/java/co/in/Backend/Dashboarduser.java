package co.in.Backend;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/dashboard")
public class Dashboarduser extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);
		if(session==null || session.getAttribute("usermail")==null) {
			res.sendRedirect("Login.html");
		    return;
		}
		   String email = (String) session.getAttribute("usermail");

	        res.setContentType("text/html");
	        res.getWriter().println("<!DOCTYPE html>\r\n"
	        		+ "<html>\r\n"
	        		+ "<head>\r\n"
	        		+ "    <title>Dashboard</title>\r\n"
	        		+ "    <link rel=\"stylesheet\" href=\"CSS/Dashboard.css\">\r\n"
	        		+ "</head>\r\n"
	        		+ "<body>\r\n"
	        		+ "\r\n"
	        		+ "<div class=\"navbar\">\r\n"
	        		+ "    <h2>MyApp</h2>\r\n"
	        		+ "    <a href=\"logout\">Logout</a>\r\n"
	        		+ "</div>\r\n"
	        		+ "\r\n"
	        		+ "<div class=\"container\">"
	        		+ "<div class=\"card\">\r\n"
	        		+ "        <h1>Welcome 👋</h1>\r\n"
	        		+ "        <p>You are logged in as:</p>\r\n"
	        		+ "        <h3>\"\"\""+ email +"\"\"\"</h3>\r\n"
	        		+ "    </div>\r\n"
	        		+ "</div>\r\n"
	        		+ "\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>");
	        res.getWriter().println("<a href='logout'>Logout</a>");
		
	}
	

}
