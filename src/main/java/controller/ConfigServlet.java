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
import java.util.Enumeration;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        String name, lots, women, local, disabled, bike, price = "";

        //handleRequest(request, response);

        name = request.getParameter("name");
        //request.setAttribute("ResponseName", name);
        ctx.setInitParameter("name", name);
        ctx.setAttribute("name", name);

        lots = request.getParameter("lots");
        //request.setAttribute("ResponseLots", lots);
        ctx.setAttribute("totalLots", lots);

        women = request.getParameter("women");
        //request.setAttribute("ResponseWomen", women);
        ctx.setAttribute("womenLots", women);

        local = request.getParameter("local");
        //request.setAttribute("ResponseLocal", local);
        ctx.setAttribute("localLots", local);

        disabled = request.getParameter("disabled");
        //request.setAttribute("ResponseDisabled", disabled);
        ctx.setAttribute("disabledLots", disabled);

        bike = request.getParameter("bike");
        ctx.setAttribute("bikeLots", bike);


        price = request.getParameter("price");
        //request.setAttribute("ResponsePrice", price);
        ctx.setAttribute("price", price);

        System.out.println(ctx.getAttribute("price"));

        RequestDispatcher view = request.getRequestDispatcher("config.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            out.write(paramName + ":");
            out.write(" ");

            String[] paramValues = request.getParameterValues(paramName);
            for (String paramValue : paramValues) {
                out.write(paramValue);
                out.write("\n");
            }

        }

        out.close();
    }
}
