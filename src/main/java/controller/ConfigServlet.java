package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utilities.requestUtilities.checkAttributes;

/**
 * Author: Jannik Hausin
 */

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (checkAttributes(req)) {
            res.setStatus(HttpServletResponse.SC_OK);
            System.out.println("Works");

        } else {
            res.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    }
}
