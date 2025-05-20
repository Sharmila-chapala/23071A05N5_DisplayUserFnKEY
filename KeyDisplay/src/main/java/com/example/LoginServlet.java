package com.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");

        User user = RegisterServlet.users.get(uname);

        res.setContentType("text/html");
        if (user != null && user.getPassword().equals(pwd)) {
            String dobOriginal = user.getDob(); // yyyy-MM-dd
            String formattedDob = "";

            try {
                // Correctly parse yyyy-MM-dd (HTML default date format)
                Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobOriginal);
                // Convert to ddMMyyyy
                formattedDob = new SimpleDateFormat("ddMMyyyy").format(dob);
            } catch (Exception e) {
                res.getWriter().println("<h3>Error parsing date of birth: " + e.getMessage() + "</h3>");
                return;
            }

            String key = user.getFirstname().substring(0, 2).toLowerCase() + formattedDob;

            res.getWriter().println("<h2>Hey " + uname + "!</h2>");
            res.getWriter().println("<p>Your key is: <strong>" + key + "</strong></p>");
        } else {
            res.getWriter().println("<h3>Invalid Credentials. <a href='login.html'>Try again</a></h3>");
        }
    }
}
