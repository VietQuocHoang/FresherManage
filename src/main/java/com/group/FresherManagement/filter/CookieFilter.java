package com.group.FresherManagement.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CookieFilter implements Filter {
    private final String USER_COOKIE_NAME = "username";

    private final String[] EXCLUDED_PATH = {
            "/resources",
            "LoginController",
    };

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookies = req.getCookies();
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI().substring(req.getContextPath().length());
        boolean isExcludedPath = false;
        for (String s : EXCLUDED_PATH) {
            if (path.contains(s)) {
                isExcludedPath = true;
                break;
            }
        }
        if (!isExcludedPath) {
            boolean isLoggedIn = false;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equalsIgnoreCase(USER_COOKIE_NAME) && cookie.getValue() != null) {
                        isLoggedIn = true;
                        break;
                    }
                }
            } else {
                isLoggedIn = false;
            }
            if (isLoggedIn) {
                filterChain.doFilter(req, servletResponse);
            } else {
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        } else {
            filterChain.doFilter(req, res);
        }
    }

    public void destroy() {

    }
}
