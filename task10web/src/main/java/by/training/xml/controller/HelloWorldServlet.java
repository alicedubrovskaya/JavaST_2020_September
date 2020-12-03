package by.training.xml.controller;

import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/parsing")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/index.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String parserType = request.getParameter("parserType");

        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder(parserType);
        String pathToProject = getServletContext().getRealPath("/");
        pathToProject = pathToProject.substring(0, pathToProject.indexOf("target"));


        Path path = Paths.get(pathToProject+ "src/main/resources/medicines.xml");
        builder.buildSetMedicines(path.toString());

        request.setAttribute("medicines", builder.getMedicines());
        request.setAttribute("parser", parserType);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/medicines.jsp");
        view.forward(request, response);
    }


}
