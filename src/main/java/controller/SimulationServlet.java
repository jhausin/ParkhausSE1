package controller;

import models.Config;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
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
        Config cfg = new Config(createJson());
        System.out.println(cfg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public JsonObject createJson(){
        ServletContext ctx = getServletContext();
        return Json.createObjectBuilder()
                .add("name", ctx.getInitParameter("name"))
                .add("lots", Integer.parseInt(ctx.getInitParameter("totalLots")))
                .add("women", Integer.parseInt(ctx.getInitParameter("womenLots")))
                .add("disabled", Integer.parseInt(ctx.getInitParameter("disabledLots")))
                .add("local", Integer.parseInt(ctx.getInitParameter("localLots")))
                .add("bike", Integer.parseInt(ctx.getInitParameter("bikeLots")))
                .add("price", ctx.getInitParameter("price"))
                .build();
    }

}
