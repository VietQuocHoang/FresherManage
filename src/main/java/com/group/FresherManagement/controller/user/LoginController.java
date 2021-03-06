package com.group.FresherManagement.controller.user;

import com.group.FresherManagement.services.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
    private static final String ERR_PAGE = "/err.jsp";
    private static final String LOGIN_PAGE = "/index.jsp";
    private static final String DASHBOARD = "Dashboard";
    private UserServices userServices;

    @Override
    public void init() throws ServletException {
        userServices = new UserServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERR_PAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        RequestDispatcher requestDispatcher;
//        PrintWriter out = response.getWriter();
        int check = 0;
        if ("".equals(username) || "".equals(password)) {
//            out.println("<h1 style='color:red;'>Username or Password must not be empty</h1><br/>");
            check = 1;
            request.setAttribute("check", check);
            url = LOGIN_PAGE;
            requestDispatcher = request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        } else {
            boolean checkLogin = userServices.login(username, password);
            if (checkLogin) {
                Cookie cookie = new Cookie("username", username);
                url = DASHBOARD;
                response.addCookie(cookie);
                response.sendRedirect(url);
            } else {
//                String err = "<h1 style='color:red;'>Username or Password must not be empty</h1><br/>";
                check = 2;
                url = LOGIN_PAGE;
                request.setAttribute("check", check);
                requestDispatcher = request.getRequestDispatcher(url);
                requestDispatcher.forward(request, response);
            }
        }
    }
}
