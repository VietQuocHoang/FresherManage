package com.group.FresherManagement.controller.fresher;

import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.services.FresherServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SaveFresherController", urlPatterns = "/SaveFresher")
public class SaveFresherController extends HttpServlet {
    private FresherServices fresherServices;
    private static String FRESHER_CONTROLLER = "FresherController";

    @Override
    public void init() throws ServletException {
        fresherServices = new FresherServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String dob = request.getParameter("txtDob");
        String sex = request.getParameter("rbtSex");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday = null;
        boolean chkSex = false;
        int state = Integer.parseInt(request.getParameter("btnAction"));
        Fresher fresher = new Fresher();
        try {
            if (state == 1) {
                birthday = new Date(dateFormat.parse(dob).getTime());
            }
            if (state == 2) {
                int id = Integer.parseInt(request.getParameter("txtId"));
                fresher.setId(id);
                String birthDayStr = dob.replace("-", "/");
                dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                birthday = new Date(dateFormat.parse(birthDayStr).getTime());
            }
            if (sex.equals("Male")) {
                chkSex = true;
            }
            fresher.setFirstName(firstName);
            fresher.setLastName(lastName);
            fresher.setEmail(email);
            fresher.setPhone(phone);
            fresher.setDob(birthday);
            fresher.setSex(chkSex);

            fresherServices.saveFresher(fresher, state);
        } catch (ParseException ex) {
            Logger.getLogger(SaveFresherController.class.getName()).log(Level.SEVERE, "Exception at SaveFresherController", ex);
        }

        response.sendRedirect(FRESHER_CONTROLLER);
    }
}
