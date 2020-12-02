package by.training.xml.controller;

import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/Hello")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Hello World!</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Hello World!</h1>");
//        out.println("</body>");
//        out.println("</html>");

        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("stax");
        String pathToProject = getServletContext().getRealPath("/");
        pathToProject = pathToProject.substring(0, pathToProject.indexOf("target"));
        builder.buildSetMedicines(pathToProject + "src/main/resources/medicines.xml");

        request.setAttribute("medicines", builder.getMedicines());

        RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/medicines.jsp");
        view.forward(request, response);
    }
}
