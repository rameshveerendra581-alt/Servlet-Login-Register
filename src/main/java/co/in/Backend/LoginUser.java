package co.in.Backend;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUser.DBconnectionuser;
@WebServlet("/login1")
public class LoginUser extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try {
            Connection con = DBconnectionuser.getConnection();
            if (con == null) {
                res.getWriter().println("DB connection failed");
                return;
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("usermail", email);

                res.sendRedirect("dashboard");
            } else {
                res.getWriter().println("❌ Invalid Email or Password");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Login error");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.sendRedirect("login.html");
    }
}
