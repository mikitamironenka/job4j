package ru.job4j.lesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassingParameterUsingGet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String title = "Passing parameters using GET method";

        String docType = "<!DOCTYPE html>";

        writer.println("<html>" +
            "<head><title>" + title + "</title></head>\n" +
            "<body><h2>Specialty: </h2>" + request.getParameter("specialty") +
            "<h2>Experience: </h2>" + request.getParameter("experience")
            + "</body>" +
            "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
