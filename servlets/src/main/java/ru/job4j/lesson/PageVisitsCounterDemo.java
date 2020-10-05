package ru.job4j.lesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PageVisitsCounterDemo extends HttpServlet {

    private volatile int visitCounter;

    public void init() {
        visitCounter = 0;
    }

    synchronized void increaseAmountOfVisits() {
        visitCounter++;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        increaseAmountOfVisits();
        resp.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Visits Counter Demo";
        PrintWriter writer = resp.getWriter();

        writer.println(docType + "<html>" +
            "<head>" +
            "<title>" + title +
            "</title>" +
            "</head>" +
            "<body>" +
            "<h1>Visits amount: </h1>" +
            visitCounter +
            "</body>" +
            "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
