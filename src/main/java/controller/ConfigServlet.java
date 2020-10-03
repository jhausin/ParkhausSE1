package controller;

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

import static utilities.requestUtilities.*;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        getRequestParams(req);
        System.out.println(checkAttributes(req));
        JsonObject cfg = createJson(req);
        System.out.println(cfg);
        //getContextParams(req);
        res.sendRedirect("/views/simulation");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    }
}
