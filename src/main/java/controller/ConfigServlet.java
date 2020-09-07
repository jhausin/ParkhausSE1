package controller;

import javax.json.Json;
import javax.json.JsonArray;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletConfig().getServletContext();
        String name, lots, women, abo, disabled, price = "";

        name = request.getParameter("name");
        request.setAttribute("ResponseName", name);

        lots = request.getParameter("lots");
        request.setAttribute("ResponseLots", lots);

        women = request.getParameter("women");
        request.setAttribute("ResponseWomen", women);

        abo = request.getParameter("abo");
        request.setAttribute("ResponseAbo", abo);

        disabled = request.getParameter("disabled");
        request.setAttribute("ResponseDisabled", disabled);

        price = request.getParameter("price");
        request.setAttribute("ResponsePrice", price);

        RequestDispatcher view = request.getRequestDispatcher("config.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
