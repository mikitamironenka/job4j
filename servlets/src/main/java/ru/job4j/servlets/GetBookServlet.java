package ru.job4j.servlets;

import ru.job4j.controller.BookStore;
import ru.job4j.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetBookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GetBookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        BookStore dao = BookStore.instOf();

        try {
            Book book = dao.getBook(bookId);

            request.setAttribute("book", book);

            String page = "/index.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
}
