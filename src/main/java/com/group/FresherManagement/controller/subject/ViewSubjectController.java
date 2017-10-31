package com.group.FresherManagement.controller.subject;

import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "viewSubject", urlPatterns = "/viewSubject")
public class ViewSubjectController extends HttpServlet {
    private SubjectServices subjectServices;

    @Override
    public void init() throws ServletException {
        subjectServices = new SubjectServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e){
            PrintWriter out = resp.getWriter();
            out.println("Invalid request");
            out.close();
        }
        Subject subject = subjectServices.findSubjectById(id);
        if (subject == null) {
            resp.sendRedirect("subjects");
        } else {
            List<CoursesSubject> coursesSubjectList = subjectServices.getEquivalentCourses(subject);
            req.setAttribute("subject", subject);
            req.setAttribute("coursesEqui", coursesSubjectList);
            req.getRequestDispatcher("subject-detail.jsp").forward(req, resp);
        }

    }
}
