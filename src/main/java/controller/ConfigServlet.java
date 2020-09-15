package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static utilities.requestUtilities.getRequestParams;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        getRequestParams(request);
        String name, lots, women, local, disabled, bike, price = "";

        //handleRequest(request, response);
        name = request.getParameter("name");
        //request.setAttribute("ResponseName", name);
        request.setAttribute("name", name);

        lots = request.getParameter("lots");
        //request.setAttribute("ResponseLots", lots);
        request.setAttribute("totalLots", lots);

        women = request.getParameter("women");
        //request.setAttribute("ResponseWomen", women);
        request.setAttribute("womenLots", women);

        local = request.getParameter("local");
        //request.setAttribute("ResponseLocal", local);
        request.setAttribute("localLots", local);

        disabled = request.getParameter("disabled");
        //request.setAttribute("ResponseDisabled", disabled);
        ctx.setAttribute("disabledLots", disabled);

        bike = request.getParameter("bike");
        request.setAttribute("bikeLots", bike);


        price = request.getParameter("price");
        //request.setAttribute("ResponsePrice", price);
        ctx.setAttribute("price", price);

        //System.out.println(ctx.getAttribute("price"));

        RequestDispatcher view = request.getRequestDispatcher("simulation.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
