package com.group.FresherManagement.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = "/LogoutController")
public class LogoutController extends HttpServlet {
    private static final String LOGIN_PAGE = "/index.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("text/html");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect(getServletContext().getContextPath() + LOGIN_PAGE);
    }
}
