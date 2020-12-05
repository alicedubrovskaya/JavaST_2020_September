package by.training.xml.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/parsing")
public class HelloWorldServlet extends HttpServlet {
    private final Controller controller = new Controller();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/index.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String parserType = request.getParameter("parserType");

        request.setAttribute("medicines", controller.parseXML(parserType, getServletContext().getRealPath("/")));
        request.setAttribute("parser", parserType);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/medicines.jsp");
        view.forward(request, response);
    }


}
