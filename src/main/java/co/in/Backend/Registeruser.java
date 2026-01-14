package co.in.Backend;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUser.DBconnectionuser;
@WebServlet("/register")
public class Registeruser extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String sql="insert into users(name,email,password) values(?,?,?)";
		try {
			Connection con =DBconnectionuser.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			  ps.setString(1, name);
	           ps.setString(2, email);
	           ps.setString(3, password);
	           
	           ps.executeUpdate();
	           res.sendRedirect("Login.html");
	           
		}catch(Exception e) {
			e.printStackTrace();
			res.getWriter().println("Registration Failed");
		}
	}

}
