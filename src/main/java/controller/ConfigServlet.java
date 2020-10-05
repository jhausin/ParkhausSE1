package controller;

import models.CarPark;
import models.Config;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utilities.requestUtilities.checkAttributes;
import static utilities.requestUtilities.createJson;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (checkAttributes(req)) { //if Configuration is valid => create car park and save to servletcontext
            JsonObject cfg = createJson(req);
            CarPark carPark = new CarPark(new Config(cfg));
            getServletContext().setAttribute("carPark", carPark);
            res.setStatus(HttpServletResponse.SC_OK);

        } else { //else send error
            res.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
}
