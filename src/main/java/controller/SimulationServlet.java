package controller;

import models.Config;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimulationServlet")
public class SimulationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Config cfg;
        if(checkAttributes(request)) {
            cfg = new Config(createJson(request));
        }
        else{
            cfg = new Config();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setAttribute("config", cfg);

        RequestDispatcher view = request.getRequestDispatcher("simulation.jsp");
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public JsonObject createJson(HttpServletRequest request){
        return Json.createObjectBuilder()
                .add("name", (String)request.getAttribute("name"))
                .add("lots", (int)request.getAttribute("totalLots"))
                .add("women", (int)request.getAttribute("womenLots"))
                .add("disabled",(int)request.getAttribute("disabledLots"))
                .add("local", (int)request.getAttribute("localLots"))
                .add("bike", (int)request.getAttribute("bikeLots"))
                .add("price", (double)request.getAttribute("price"))
                .build();
    }
    public boolean checkAttributes(HttpServletRequest request){
        return request.getAttribute("name") != null
                || request.getAttribute("totalLots") != null
                || request.getAttribute("womenLots") != null
                || request.getAttribute("disabledLots") != null
                || request.getAttribute("localLots") != null
                || request.getAttribute("bikeLots") != null
                || request.getAttribute("price") != null;
    }

}
