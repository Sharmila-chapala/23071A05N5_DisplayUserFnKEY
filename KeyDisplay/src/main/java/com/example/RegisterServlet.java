package com.example;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    public static HashMap<String, User> users = new HashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        String uname = req.getParameter("username");
        String branch = req.getParameter("branch");
        String gmail = req.getParameter("gmail");
        String pwd = req.getParameter("password");
        String cpwd = req.getParameter("confirmpassword");
        String dob = req.getParameter("dob");

        res.setContentType("text/html");
        if (!pwd.equals(cpwd)) {
            res.getWriter().println("<h3>Passwords do not match. Please go back and try again.</h3>");
            return;
        }

        User user = new User(fname, lname, uname, gmail, pwd, dob);
        users.put(uname, user);

        res.getWriter().println("<h3>Registration successful. <a href='login.html'>Click here to login</a></h3>");
    }
}
